package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceSurrenderProcessEntity;

@Service
public interface CertificateServiceSurrenderProcessRepository extends JpaRepository<CertificateServiceSurrenderProcessEntity, Long>{
    
}
