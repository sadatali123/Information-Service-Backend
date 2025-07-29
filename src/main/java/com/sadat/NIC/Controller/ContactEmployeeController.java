package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.ContactEmployee;
import com.sadat.NIC.Service.ContactEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/employees")
public class ContactEmployeeController {

    @Autowired
    private ContactEmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ContactEmployee> add(@RequestBody ContactEmployee employee) {
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<ContactEmployee> update(@PathVariable Long id, @RequestBody ContactEmployee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @GetMapping("/getall")

    public ResponseEntity<List<ContactEmployee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/getbyid/{id}")

    public ResponseEntity<ContactEmployee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }
}

