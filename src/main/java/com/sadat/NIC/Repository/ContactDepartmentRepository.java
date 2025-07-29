package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.ContactDepartment;

import java.util.Optional;

public interface ContactDepartmentRepository extends JpaRepository<ContactDepartment, Long> {
    Optional<ContactDepartment> findByDeptNameAndType(String deptName, String type);
}

