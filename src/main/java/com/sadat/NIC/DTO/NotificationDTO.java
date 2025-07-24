package com.sadat.NIC.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private Long id;
    private Long userId;
    private Long grievanceId;   // optional
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
