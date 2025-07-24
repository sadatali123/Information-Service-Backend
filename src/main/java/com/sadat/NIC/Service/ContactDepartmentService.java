package com.sadat.NIC.Service;

import com.sadat.NIC.DTO.C_DepartmentDetailsDTO;
import com.sadat.NIC.Entity.C_Department;

import java.util.List;

public interface ContactDepartmentService {
    C_Department add(C_Department dept);
    C_Department update(Long id, C_Department updatedDept);
    List<C_Department> getAll();
    C_Department getById(Long id);
    C_Department togglePending(Long id);
    C_DepartmentDetailsDTO getDepartmentDetails(Long id);
    
    
}




 



