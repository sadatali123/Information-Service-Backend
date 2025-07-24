package com.sadat.NIC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateServiceSurrenderProcessDTO {
    private Long id;
    private String serviceName;
    private Long stepNo;
    private String stepDetails;
}
