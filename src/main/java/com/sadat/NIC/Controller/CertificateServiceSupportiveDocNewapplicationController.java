package com.sadat.NIC.Controller;

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
import com.sadat.NIC.Entity.CertificateServiceSupportiveDocNewapplicationEntity;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocNewapplicationService;

@RestController
@RequestMapping("/api/supportiveDoc-newapplication")
@CrossOrigin(origins = "http://localhost:5173/supportive-document")
public class CertificateServiceSupportiveDocNewapplicationController {
    @Autowired
    private CertificateServiceSupportiveDocNewapplicationService service;

    @GetMapping("/get-all")
    public List<CertificateServiceSupportiveDocNewapplicationEntity> getAllSupportiveDocs() {
        return service.getAllSupportiveDoc();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocNewapplicationEntity> getSupportiveDocById(@PathVariable Long id) {
        CertificateServiceSupportiveDocNewapplicationEntity doc = service.getSupportiveDocById(id);
        return ResponseEntity.ok(doc);
    }

    @PostMapping("/create")
    public ResponseEntity<CertificateServiceSupportiveDocNewapplicationEntity> createSupportiveDoc(
            @RequestBody CertificateServiceSupportiveDocNewapplicationEntity entity) {
        CertificateServiceSupportiveDocNewapplicationEntity saved = service.createSupportiveDoc(entity);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocNewapplicationEntity> updateSupportiveDoc(
            @PathVariable Long id,
            @RequestBody CertificateServiceSupportiveDocNewapplicationEntity entity) {
        CertificateServiceSupportiveDocNewapplicationEntity updated = service.updateSupportiveDoc(id, entity);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupportiveDoc(@PathVariable Long id) {
        service.deleteSupportiveDoc(id);
        return ResponseEntity.noContent().build();
    }
}
