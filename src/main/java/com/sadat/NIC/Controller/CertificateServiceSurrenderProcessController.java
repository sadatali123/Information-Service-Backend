package com.sadat.NIC.Controller;

import java.util.List;

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

import com.sadat.NIC.Entity.CertificateServiceSurrenderProcessEntity;
import com.sadat.NIC.Service.CertificateServiceSurrenderProcessService;

@RestController
@RequestMapping("/api/surrender-process")
@CrossOrigin(origins = "http://localhost:5173/add-process")
public class CertificateServiceSurrenderProcessController {
    @Autowired
    private CertificateServiceSurrenderProcessService service;

    @GetMapping("/get-all")
    public List<CertificateServiceSurrenderProcessEntity> getAll() {
        return service.getAllSurrenderProcess();
    }

    @GetMapping("/get/{id}")
    public CertificateServiceSurrenderProcessEntity getById(@PathVariable Long id) {
        return service.getSurrenderProcessById(id);
    }

    @PostMapping("/create")
    public CertificateServiceSurrenderProcessEntity create(@RequestBody CertificateServiceSurrenderProcessEntity entity) {
        return service.createSurrenderProcess(entity);
    }

    @PutMapping("/update/{id}")
    public CertificateServiceSurrenderProcessEntity update(@PathVariable Long id, @RequestBody CertificateServiceSurrenderProcessEntity entity) {
        return service.updateSurrenderProcess(id, entity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteSurrenderProcess(id);
        return "Deleted successfully with id: " + id;
    }
}
