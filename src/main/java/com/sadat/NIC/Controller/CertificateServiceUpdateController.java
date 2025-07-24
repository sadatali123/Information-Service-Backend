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

import com.sadat.NIC.Entity.CertificateServiceUpdateProcessEntity;
import com.sadat.NIC.Service.CertificateServiceUpdateService;

@RestController
@RequestMapping("/api/update-process")
@CrossOrigin(origins="http://localhost:5173/add-process")
public class CertificateServiceUpdateController {
    @Autowired
    private CertificateServiceUpdateService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<CertificateServiceUpdateProcessEntity>> getAll() {
        return ResponseEntity.ok(service.getAllUpdateProcess());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceUpdateProcessEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUpdateProcessById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CertificateServiceUpdateProcessEntity> create(@RequestBody CertificateServiceUpdateProcessEntity entity) {
        return ResponseEntity.ok(service.createUpdateProcess(entity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceUpdateProcessEntity> update(@PathVariable Long id, @RequestBody CertificateServiceUpdateProcessEntity entity) {
        return ResponseEntity.ok(service.updateUpdateProcess(id, entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteUpdateProcess(id);
        return ResponseEntity.noContent().build();
    }
}
