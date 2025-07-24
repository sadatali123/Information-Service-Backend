package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocNewapplicationEntity;

@Repository
public interface CertificateServiceSupportiveDocNewapplicationRepository extends JpaRepository<CertificateServiceSupportiveDocNewapplicationEntity, Long>  {
    
}
