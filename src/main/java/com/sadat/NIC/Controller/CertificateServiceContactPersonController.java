package com.sadat.NIC.Controller;


import com.sadat.NIC.Entity.CertificateServiceContactPersonEntity;
import com.sadat.NIC.Service.CertificateServiceContactPersonService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/contact-persons")
@CrossOrigin(origins = "http://localhost:5173")
public class CertificateServiceContactPersonController {
    @Autowired
    private CertificateServiceContactPersonService service;

    @GetMapping("/get-all")
    public List<CertificateServiceContactPersonEntity> getAllContactPersons() {
        return service.getAllContactPerson();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceContactPersonEntity> getContactPersonById(@PathVariable Long id) {
        CertificateServiceContactPersonEntity contact = service.getContactPersonById(id);
        return ResponseEntity.ok(contact);
    }

    @PostMapping("/create")
    public ResponseEntity<CertificateServiceContactPersonEntity> createContactPerson(@RequestBody CertificateServiceContactPersonEntity entity) {
        CertificateServiceContactPersonEntity saved = service.createContactPerson(entity);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceContactPersonEntity> updateContactPerson(@PathVariable Long id, @RequestBody CertificateServiceContactPersonEntity entity) {
        CertificateServiceContactPersonEntity updated = service.updateContactPerson(id, entity);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContactPerson(@PathVariable Long id) {
        service.deleteContactPerson(id);
        return ResponseEntity.noContent().build();
    }
}
