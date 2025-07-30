package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.Attachment;
import com.sadat.NIC.DTO.AttachmentDTO;
import com.sadat.NIC.Service.AttachmentService;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class G_AttachmentController {

    private final AttachmentService attachmentService;

    public G_AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    // Upload file
    @PostMapping("/upload")
    public ResponseEntity<AttachmentDTO> uploadFile(@RequestParam("filename") MultipartFile file,
            @RequestParam("linkedEntityId") Long linkedEntityId) {
        try {
            Attachment attachment = attachmentService.saveAttachment(file, linkedEntityId);
            return ResponseEntity.ok(attachmentService.convertToDTO(attachment));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    // Download file by ID
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) throws IOException {
        Attachment attachment = attachmentService.getAttachment(id);
        if (attachment == null) {
            return ResponseEntity.notFound().build();
        }
        byte[] data = attachmentService.getFileData(attachment.getFilePath());
        String filename = attachment.getFilePath().substring(attachment.getFilePath().lastIndexOf('/') + 1);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(data);
    }

    // Get all attachments
    @GetMapping
    public List<AttachmentDTO> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    // Get attachments by linked entity ID
    @GetMapping("/linked/{linkedEntityId}")
    public List<AttachmentDTO> getByLinkedEntityId(@PathVariable Long linkedEntityId) {
        return attachmentService.getAttachmentsByLinkedEntityId(linkedEntityId)
                .stream()
                .map(attachmentService::convertToDTO)
                .collect(Collectors.toList());
    }

    // Delete attachment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }
}