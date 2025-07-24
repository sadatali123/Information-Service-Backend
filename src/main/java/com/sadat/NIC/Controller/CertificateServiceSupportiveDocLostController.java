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

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocLostEntity;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocLostService;

@RestController
@RequestMapping("/api/SupportiveDoc-lost")
@CrossOrigin(origins = "http://localhost:5173/supportive-document")
public class CertificateServiceSupportiveDocLostController {
    @Autowired
    private CertificateServiceSupportiveDocLostService service;
    
    @GetMapping("/get-all")
    public List<CertificateServiceSupportiveDocLostEntity> getAllSupportiveDocs() {
        return service.getAllSupportiveDoc();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocLostEntity> getSupportiveDocById(@PathVariable Long id) {
        CertificateServiceSupportiveDocLostEntity doc = service.getSupportiveDocById(id);
        return ResponseEntity.ok(doc);
    }
    @PostMapping("/create")
    public ResponseEntity<CertificateServiceSupportiveDocLostEntity> createSupportiveDoc(@RequestBody CertificateServiceSupportiveDocLostEntity entity) {
        CertificateServiceSupportiveDocLostEntity saved = service.createSupportiveDoc(entity);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocLostEntity> updateSupportiveDoc(@PathVariable Long id, @RequestBody CertificateServiceSupportiveDocLostEntity entity) {
        CertificateServiceSupportiveDocLostEntity updated = service.updateSupportiveDoc(id, entity);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupportiveDoc(@PathVariable Long id) {
        service.deleteSupportiveDoc(id);
        return ResponseEntity.noContent().build();
    }

}
