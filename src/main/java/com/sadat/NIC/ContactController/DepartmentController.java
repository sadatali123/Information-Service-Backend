package com.sadat.NIC.ContactController;

import com.sadat.NIC.ContactDTO.DepartmentDetailsDTO;
import com.sadat.NIC.ContactEntity.Department;
import com.sadat.NIC.ContactService.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

 @PostMapping("/add")
public ResponseEntity<?> add(@RequestBody Department dept) {
    try {
        Department created = departmentService.add(dept);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409
    }
}


    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDept) {
        return departmentService.update(id, updatedDept);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/departmentSummarry/{id}")
    public ResponseEntity<DepartmentDetailsDTO> getDepartmentDetails(@PathVariable Long id) {
    return ResponseEntity.ok(departmentService.getDepartmentDetails(id));
}

}

