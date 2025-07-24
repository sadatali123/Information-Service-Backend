package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocSurrenderEntity;

@Repository
public interface CertificateServiceSupportiveDocSurrenderRepository extends JpaRepository<CertificateServiceSupportiveDocSurrenderEntity, Long> {
    
}
