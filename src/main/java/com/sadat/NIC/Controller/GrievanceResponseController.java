package com.sadat.NIC.Controller;

import com.sadat.NIC.DTO.GrievanceResponseDTO;
import com.sadat.NIC.Entity.GrievanceResponse;
import com.sadat.NIC.Service.GrievanceResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/grievances/responses")
@CrossOrigin(origins = "*")
public class GrievanceResponseController {
    private final GrievanceResponseService responseService;

    public GrievanceResponseController(GrievanceResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/{grievanceId}/respond")
    public ResponseEntity<GrievanceResponseDTO> addResponse(@PathVariable Long grievanceId,
            @RequestBody GrievanceResponseDTO dto) {

        GrievanceResponse response = new GrievanceResponse();

        responseService.addResponse(response);

        GrievanceResponseDTO savedDto = new GrievanceResponseDTO();
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping("/{grievanceId}/responses")
    public ResponseEntity<List<GrievanceResponseDTO>> getResponsesByGrievanceId(@PathVariable Long grievanceId) {
        List<GrievanceResponse> responses = responseService.getResponsesByGrievanceId(grievanceId);
        List<GrievanceResponseDTO> dtos = responses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    private GrievanceResponseDTO mapToDTO(GrievanceResponse response) {
        GrievanceResponseDTO dto = new GrievanceResponseDTO();
        return dto;
    }
}