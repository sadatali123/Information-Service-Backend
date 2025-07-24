package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadat.NIC.Entity.CertificateServiceNewapplicationProcessEntity;

@Repository
public interface CertificateServiceNewapplicationRepository extends JpaRepository<CertificateServiceNewapplicationProcessEntity, Long> {
    
}
