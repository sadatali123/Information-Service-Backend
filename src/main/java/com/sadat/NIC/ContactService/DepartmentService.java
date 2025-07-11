package com.sadat.NIC.ContactService;

import com.sadat.NIC.ContactDTO.DepartmentDetailsDTO;
import com.sadat.NIC.ContactEntity.Department;
import java.util.List;

public interface DepartmentService {
    Department add(Department dept);
    Department update(Long id, Department updatedDept);
    List<Department> getAll();
    Department getById(Long id);
    Department togglePending(Long id);
    DepartmentDetailsDTO getDepartmentDetails(Long id);
    
    
}




 



