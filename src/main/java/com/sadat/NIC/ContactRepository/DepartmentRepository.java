package com.sadat.NIC.ContactRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sadat.NIC.ContactEntity.Department;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDeptNameAndType(String deptName, String type);
}

