package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.ContactOffice;
import com.sadat.NIC.Service.ContactOfficeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/offices")
public class ContactOfficeController {

    @Autowired
    private ContactOfficeService officeService;

    @PostMapping("/add")
    public ResponseEntity<ContactOffice> add(@RequestBody ContactOffice office) {
        return new ResponseEntity<>(officeService.add(office), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactOffice> update(@PathVariable Long id, @RequestBody ContactOffice office) {
        return ResponseEntity.ok(officeService.update(id, office));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ContactOffice>> getAll() {
        return ResponseEntity.ok(officeService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ContactOffice> getById(@PathVariable Long id) {
        return ResponseEntity.ok(officeService.getById(id));
    }
}
