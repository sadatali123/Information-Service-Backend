package com.sadat.NIC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateServiceDTO {
    private Long id;
    private String name;
    private String serviceSummary;
    private String applicationMode;
    private String url;
    private String officeAddress;
    private Long eligibility;
    private String shortForm;
}
