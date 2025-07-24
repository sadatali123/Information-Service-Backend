package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.CertificateServiceEntity;
import com.sadat.NIC.Service.Impl.CertificateServiceImpl;

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
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173/new-application")
public class CertificateServiceController {
    @Autowired
    private CertificateServiceImpl CertificateService;

    @GetMapping("/get-all")
    public ResponseEntity<List< CertificateServiceEntity>> getAllServices() {
        return ResponseEntity.ok(CertificateService.getAllServices());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity< CertificateServiceEntity> getServiceById(@PathVariable Long id) {
         CertificateServiceEntity service = CertificateService.getServiceById(id);
        return service != null ? ResponseEntity.ok(service) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody  CertificateServiceEntity service) {
        return CertificateService.createService(service);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity< CertificateServiceEntity> updateService(@PathVariable Long id, @RequestBody  CertificateServiceEntity service) {
         CertificateServiceEntity updated = CertificateService.updateService(id, service);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
    boolean deleted = CertificateService.deleteService(id);
    return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/published/{id}")
    public ResponseEntity<Boolean> isServicePublished(@PathVariable Long id) {
        return ResponseEntity.ok(CertificateService.isServicePublished(id));
    }

    // @GetMapping("/{id}/exists")
    // public boolean checkExists(@PathVariable Long id) {
    //     return infoService.isServiceExists(id);
    // }
    
}
