package com.sadat.NIC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateServiceContactPersonDTO {
    private Long id;
    private String serviceName;
    private String district;
    private String subDivision;
    private String block;
    private String officeAddress;
    private String employeeName;
    private String employeeDesignation;
    private String email;
    private String contact;
}

