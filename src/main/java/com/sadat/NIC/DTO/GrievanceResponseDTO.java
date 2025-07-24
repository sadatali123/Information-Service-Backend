package com.sadat.NIC.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GrievanceResponseDTO {
    private Long id;
    private Long grievanceId;
    private Long responderId;
    private String comment;
    private String actionTaken;
    private LocalDateTime createdAt;
}
