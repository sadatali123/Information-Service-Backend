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
@Table(name="Service_Contact_Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateServiceContactPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
