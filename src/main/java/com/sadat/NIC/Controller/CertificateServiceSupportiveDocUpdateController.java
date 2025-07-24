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

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocUpdateEntity;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocUpdateService;

@RestController
@RequestMapping("/api/SupportiveDoc-update")
@CrossOrigin(origins = "http://localhost:5173/supportive-document")
public class CertificateServiceSupportiveDocUpdateController {
    @Autowired
    private CertificateServiceSupportiveDocUpdateService service;

    @GetMapping("/get-all")
    public List<CertificateServiceSupportiveDocUpdateEntity> getAllSupportiveDocs() {
        return service.getAllSupportiveDoc();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocUpdateEntity> getSupportiveDocById(@PathVariable Long id) {
        CertificateServiceSupportiveDocUpdateEntity doc = service.getSupportiveDocById(id);
        return ResponseEntity.ok(doc);
    }
    @PostMapping("/create")
    public ResponseEntity<CertificateServiceSupportiveDocUpdateEntity> createSupportiveDoc(@RequestBody CertificateServiceSupportiveDocUpdateEntity entity) {
        CertificateServiceSupportiveDocUpdateEntity saved = service.createSupportiveDoc(entity);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceSupportiveDocUpdateEntity> updateSupportiveDoc(@PathVariable Long id, @RequestBody CertificateServiceSupportiveDocUpdateEntity entity) {
        CertificateServiceSupportiveDocUpdateEntity updated = service.updateSupportiveDoc(id, entity);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupportiveDoc(@PathVariable Long id) {
        service.deleteSupportiveDoc(id);
        return ResponseEntity.noContent().build();
    }

}
