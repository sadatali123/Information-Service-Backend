
package com.sadat.NIC.ContactRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sadat.NIC.ContactEntity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}