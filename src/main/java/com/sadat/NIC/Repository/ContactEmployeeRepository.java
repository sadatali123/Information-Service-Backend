
package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.ContactEmployee;

public interface ContactEmployeeRepository extends JpaRepository<ContactEmployee, Long> {
    
}