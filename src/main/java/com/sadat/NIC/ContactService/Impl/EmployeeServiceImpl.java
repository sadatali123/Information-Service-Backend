package com.sadat.NIC.ContactService.Impl;

import com.sadat.NIC.ContactEntity.Employee;
import com.sadat.NIC.ContactRepository.EmployeeRepository;
import com.sadat.NIC.ContactService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee updatedEmployee) {
        Employee existing = employeeRepository.findById(id).orElseThrow();
        existing.setName(updatedEmployee.getName());
        existing.setDesignation(updatedEmployee.getDesignation());
        existing.setContact(updatedEmployee.getContact());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setPost(updatedEmployee.getPost());
        return employeeRepository.save(existing);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee toggleActive(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setActive(!employee.isActive());
        return employeeRepository.save(employee);
    }
}