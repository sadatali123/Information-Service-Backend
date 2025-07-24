package com.sadat.NIC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDTO {
    private Long id;
    private Long linkedEntityId;
    private String filePath;
    private String fileType;
    private String uploadedAt; 
}