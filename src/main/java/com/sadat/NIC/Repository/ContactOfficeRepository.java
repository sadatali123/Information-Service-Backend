package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.ContactOffice;

public interface ContactOfficeRepository extends JpaRepository<ContactOffice, Long> {
    
}
