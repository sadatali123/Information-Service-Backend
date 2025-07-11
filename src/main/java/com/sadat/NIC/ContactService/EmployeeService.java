package com.sadat.NIC.ContactService;

import com.sadat.NIC.ContactEntity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);
    Employee update(Long id, Employee updatedEmployee);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee toggleActive(Long id);
}

