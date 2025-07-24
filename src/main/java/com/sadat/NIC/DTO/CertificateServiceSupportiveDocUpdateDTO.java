package com.sadat.NIC.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateServiceSupportiveDocUpdateDTO {
    private Long id;
    private String shortForm;
    private Long slNo;
    private String doctype;
    private String proofDoc;
}
