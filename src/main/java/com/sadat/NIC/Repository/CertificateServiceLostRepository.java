package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sadat.NIC.Entity.CertificateServiceLostProcessEntity;

@Repository
public interface CertificateServiceLostRepository extends JpaRepository<CertificateServiceLostProcessEntity, Long>  {
    
}
