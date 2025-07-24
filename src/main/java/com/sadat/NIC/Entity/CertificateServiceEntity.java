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
@Table(name="service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serviceSummary;
    private String applicationMode;
    private String url;
    private String officeAddress;
    private Long eligibility;
    private String shortForm;

}
