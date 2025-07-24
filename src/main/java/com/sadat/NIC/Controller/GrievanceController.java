package com.sadat.NIC.Controller;

import com.sadat.NIC.DTO.GrievanceDTO;
import com.sadat.NIC.Entity.Grievance;
import com.sadat.NIC.Service.GrievanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/grievances")
@CrossOrigin(origins = "*")
public class GrievanceController {
    private final GrievanceService grievanceService;

    public GrievanceController(GrievanceService grievanceService) {
        this.grievanceService = grievanceService;
    }

    @PostMapping("/add")
    public ResponseEntity<GrievanceDTO> addGrievance(@RequestBody GrievanceDTO dto) {
        Grievance grievance = mapToEntity(dto);
        Grievance saved = grievanceService.addGrievance(grievance);
        GrievanceDTO savedDto = mapToDTO(saved);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<GrievanceDTO> getGrievance(@PathVariable Long id) {
        return grievanceService.getById(id)
                .map(grievance -> ResponseEntity.ok(mapToDTO(grievance)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<GrievanceDTO>> getAll() {
        List<Grievance> list = grievanceService.getAll();

        List<GrievanceDTO> dtos = list.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<GrievanceDTO> updateStatus(@PathVariable Long id, @RequestBody String statusStr) {
        Grievance.Status status = Grievance.Status.valueOf(statusStr);
        Grievance updated = grievanceService.updateStatus(id, status);
        if (updated != null) {
            GrievanceDTO updatedDto = mapToDTO(updated);
            return ResponseEntity.ok(updatedDto);
        }
        return ResponseEntity.notFound().build();
    }
















    
    private GrievanceDTO mapToDTO(Grievance grievance) {
        GrievanceDTO dto = new GrievanceDTO();
        dto.setId(grievance.getId());
        dto.setSubject(grievance.getSubject());
        dto.setDescription(grievance.getDescription());
        dto.setStatus(grievance.getStatus());
        dto.setIsAnonymous(grievance.getIsAnonymous());
        dto.setCreatedAt(grievance.getCreatedAt());
        dto.setUpdatedAt(grievance.getUpdatedAt());
        return dto;
    }

    private Grievance mapToEntity(GrievanceDTO dto) {
        Grievance grievance = new Grievance();
        grievance.setId(dto.getId());
        grievance.setSubject(dto.getSubject());
        grievance.setDescription(dto.getDescription());
        grievance.setStatus(dto.getStatus());
        grievance.setIsAnonymous(dto.getIsAnonymous());
        grievance.setCreatedAt(dto.getCreatedAt());
        grievance.setUpdatedAt(dto.getUpdatedAt());
        return grievance;
    }
}
