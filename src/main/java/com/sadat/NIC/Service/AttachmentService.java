package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.Attachment;
import com.sadat.NIC.Repository.AttachmentRepository;
import com.sadat.NIC.DTO.AttachmentDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final String uploadDir = "uploads"; 

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
        // Ensure upload directory exists
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public Attachment saveAttachment(MultipartFile file, Long linkedEntityId) throws IOException {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + "/" + filename;

        // Save file to disk
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(file.getBytes());
        }

        // Save metadata to Ddata base
        Attachment attachment = new Attachment();
        attachment.setFilePath(filePath);
        attachment.setFileType(file.getContentType());
        attachment.setLinkedEntityId(linkedEntityId);
        return attachmentRepository.save(attachment);
    }

    public Attachment getAttachment(Long id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    public byte[] getFileData(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    public List<Attachment> getAttachmentsByLinkedEntityId(Long linkedEntityId) {
        return attachmentRepository.findByLinkedEntityId(linkedEntityId);
    }

    public void deleteAttachment(Long id) {
        Attachment attachment = getAttachment(id);
        if (attachment != null) {
            try {
                Files.deleteIfExists(Paths.get(attachment.getFilePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            attachmentRepository.deleteById(id);
        }
    }

    public List<AttachmentDTO> getAllAttachments() {
        return attachmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AttachmentDTO convertToDTO(Attachment attachment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new AttachmentDTO(
                attachment.getId(),
                attachment.getLinkedEntityId(),
                attachment.getFilePath(),
                attachment.getFileType(),
                attachment.getUploadedAt().format(formatter)
        );
    }
}