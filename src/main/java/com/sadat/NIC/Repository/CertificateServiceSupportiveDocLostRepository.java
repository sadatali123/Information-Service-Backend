package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocLostEntity;

@Repository
public interface CertificateServiceSupportiveDocLostRepository extends JpaRepository<CertificateServiceSupportiveDocLostEntity, Long> {
    
}
