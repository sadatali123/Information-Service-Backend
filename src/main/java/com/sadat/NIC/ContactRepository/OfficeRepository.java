package com.sadat.NIC.ContactRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sadat.NIC.ContactEntity.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
