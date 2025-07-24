package com.sadat.NIC.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="service_SupportiveDoc_Surrender")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CertificateServiceSupportiveDocSurrenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortForm;
    private Long slNo;
    private String doctype;
    private String proofDoc;
}
