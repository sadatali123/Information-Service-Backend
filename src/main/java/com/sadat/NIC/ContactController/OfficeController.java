package com.sadat.NIC.ContactController;

import com.sadat.NIC.ContactEntity.Office;
import com.sadat.NIC.ContactService.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/Office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("/add")
    public ResponseEntity<Office> add(@RequestBody Office office) {
        return new ResponseEntity<>(officeService.add(office), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Office> update(@PathVariable Long id, @RequestBody Office office) {
        return ResponseEntity.ok(officeService.update(id, office));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Office>> getAll() {
        return ResponseEntity.ok(officeService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Office> getById(@PathVariable Long id) {
        return ResponseEntity.ok(officeService.getById(id));
    }
}
