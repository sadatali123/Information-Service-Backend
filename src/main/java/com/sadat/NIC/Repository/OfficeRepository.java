package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
