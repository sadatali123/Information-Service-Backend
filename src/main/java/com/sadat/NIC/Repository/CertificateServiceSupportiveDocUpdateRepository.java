package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocUpdateEntity;

@Repository
public interface CertificateServiceSupportiveDocUpdateRepository extends JpaRepository<CertificateServiceSupportiveDocUpdateEntity, Long> {
    
}
