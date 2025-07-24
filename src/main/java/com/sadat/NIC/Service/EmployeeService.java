package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.ContactEmployee;

public interface EmployeeService {
    ContactEmployee add(ContactEmployee employee);
    ContactEmployee update(Long id, ContactEmployee updatedEmployee);
    List<ContactEmployee> getAll();
    ContactEmployee getById(Long id);
    ContactEmployee toggleActive(Long id);
}

