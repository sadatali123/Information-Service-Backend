package com.sadat.NIC.Service.Impl;

import com.sadat.NIC.Entity.ContactEmployee;
import com.sadat.NIC.Repository.ContactEmployeeRepository;
import com.sadat.NIC.Service.ContactEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactEmployeeServiceImpl implements ContactEmployeeService {

    @Autowired
    private ContactEmployeeRepository employeeRepository;

    @Override
    public ContactEmployee add(ContactEmployee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public ContactEmployee update(Long id, ContactEmployee updatedEmployee) {
        ContactEmployee existing = employeeRepository.findById(id).orElseThrow();
        existing.setName(updatedEmployee.getName());
        existing.setDesignation(updatedEmployee.getDesignation());
        existing.setContactNumber(updatedEmployee.getContactNumber());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setPost(updatedEmployee.getPost());
        return employeeRepository.save(existing);
    }

    @Override
    public List<ContactEmployee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public ContactEmployee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public ContactEmployee toggleActive(Long id) {
        ContactEmployee employee = employeeRepository.findById(id).orElseThrow();
        employee.setActive(!employee.isActive());
        return employeeRepository.save(employee);
    }
}