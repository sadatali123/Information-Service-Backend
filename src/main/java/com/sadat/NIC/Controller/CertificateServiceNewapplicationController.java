package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.CertificateServiceNewapplicationProcessEntity;
import com.sadat.NIC.Service.CertificateServiceNewapplicationService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/newapplication-process")
@CrossOrigin(origins = "http://localhost:5173/add-process")
public class CertificateServiceNewapplicationController {
    @Autowired
    private CertificateServiceNewapplicationService service;

    @GetMapping("/get-all")
    public List<CertificateServiceNewapplicationProcessEntity> getAll() {
        return service.getAllNewapplication();
    }

    @GetMapping("/get/{id}")
    public CertificateServiceNewapplicationProcessEntity getById(@PathVariable Long id) {
        return service.getNewapplicationById(id);
    }

    @PostMapping("/create")
    public CertificateServiceNewapplicationProcessEntity create(@RequestBody CertificateServiceNewapplicationProcessEntity entity) {
        return service.createNewapplication(entity);
    }

    @PutMapping("/update/{id}")
    public CertificateServiceNewapplicationProcessEntity update(@PathVariable Long id, @RequestBody CertificateServiceNewapplicationProcessEntity entity) {
        return service.updateNewapplication(id, entity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteNewapplication(id);
        return "Deleted successfully with id: " + id;
    }
}
