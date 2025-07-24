package com.sadat.NIC.DTO;

import com.sadat.NIC.Entity.Grievance.Status;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GrievanceDTO {
    private Long id;
    private String subject;
    private String description;
    private Status status;
    private Boolean isAnonymous;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
