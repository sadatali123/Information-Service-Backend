package com.sadat.NIC.Controller;

import com.sadat.NIC.DTO.ContactDepartmentDetailsDTO;
import com.sadat.NIC.Entity.ContactDepartment;
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
    public ResponseEntity<?> add(@RequestBody ContactDepartment dept) {
    try {
        ContactDepartment created = departmentService.add(dept);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409
    }
}

    @PutMapping("/update/{id}")
    public ContactDepartment updateDepartment(@PathVariable Long id, @RequestBody ContactDepartment updatedDept) {
        return departmentService.update(id, updatedDept);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ContactDepartment>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ContactDepartment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/departmentSummarry/{id}")
    public ResponseEntity<ContactDepartmentDetailsDTO> getDepartmentDetails(@PathVariable Long id) {
    return ResponseEntity.ok(departmentService.getDepartmentDetails(id));
    }
}

