package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.C_Department;

import java.util.Optional;

public interface ContactDepartmentRepository extends JpaRepository<C_Department, Long> {
    Optional<C_Department> findByDeptNameAndType(String deptName, String type);
}

