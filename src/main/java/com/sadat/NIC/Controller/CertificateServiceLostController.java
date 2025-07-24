package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.CertificateServiceLostProcessEntity;
import com.sadat.NIC.Service.CertificateServiceLostService;

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

import java.util.List;


@RestController
@RequestMapping("/api/lost-process")
@CrossOrigin(origins = "http://localhost:5173/add-process")
public class CertificateServiceLostController {
    @Autowired
    private CertificateServiceLostService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<CertificateServiceLostProcessEntity>> getAll() {
        return ResponseEntity.ok(service.getAllLostProcess());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CertificateServiceLostProcessEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLostProcessById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CertificateServiceLostProcessEntity> create(@RequestBody CertificateServiceLostProcessEntity entity) {
        return ResponseEntity.ok(service.createLostProcess(entity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CertificateServiceLostProcessEntity> update(@PathVariable Long id, @RequestBody CertificateServiceLostProcessEntity entity) {
        return ResponseEntity.ok(service.updateLostProcess(id, entity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteLostProcess(id);
        return ResponseEntity.noContent().build();
    }
}
