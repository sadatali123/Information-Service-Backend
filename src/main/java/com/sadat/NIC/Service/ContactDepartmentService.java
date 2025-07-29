package com.sadat.NIC.Service;

import com.sadat.NIC.DTO.ContactDepartmentDetailsDTO;
import com.sadat.NIC.Entity.ContactDepartment;

import java.util.List;

public interface ContactDepartmentService {
    ContactDepartment add(ContactDepartment dept);
    ContactDepartment update(Long id, ContactDepartment updatedDept);
    List<ContactDepartment> getAll();
    ContactDepartment getById(Long id);
    ContactDepartment togglePending(Long id);
    ContactDepartmentDetailsDTO getDepartmentDetails(Long id);
    
    
}




 



