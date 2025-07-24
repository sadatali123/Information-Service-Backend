package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sadat.NIC.Entity. CertificateServiceEntity;



@Repository
public interface CertificateServiceRepository extends JpaRepository< CertificateServiceEntity, Long> {
    boolean existsByName(String name);
}
