package com.sadat.NIC.Controller;

import com.sadat.NIC.DTO.C_DepartmentDetailsDTO;
import com.sadat.NIC.Entity.C_Department;
import com.sadat.NIC.Service.ContactDepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/departments")

public class ContactDepartmentController {

    @Autowired
    private ContactDepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody C_Department dept) {
    try {
        C_Department created = departmentService.add(dept);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409
    }
}

    @PutMapping("/update/{id}")
    public C_Department updateDepartment(@PathVariable Long id, @RequestBody C_Department updatedDept) {
        return departmentService.update(id, updatedDept);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<C_Department>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<C_Department> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/departmentSummarry/{id}")
    public ResponseEntity<C_DepartmentDetailsDTO> getDepartmentDetails(@PathVariable Long id) {
    return ResponseEntity.ok(departmentService.getDepartmentDetails(id));
    }
}

