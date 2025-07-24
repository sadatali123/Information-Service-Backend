package com.sadat.NIC.Service.Impl;

import com.sadat.NIC.Entity.CertificateServiceEntity;
import com.sadat.NIC.Repository.CertificateServiceRepository;
import com.sadat.NIC.Service.CertificateService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    private CertificateServiceRepository serviceRepository;

    @Override
    public List<CertificateServiceEntity> getAllServices(){
        return serviceRepository.findAll();
    }

    @Override
    public CertificateServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> createService(CertificateServiceEntity service) {
        if(isServiceExists(service.getName())){
            return ResponseEntity.badRequest().body("Service already exist with this name");
        }
        return ResponseEntity.ok(serviceRepository.save(service));
    }

    @Override
    public CertificateServiceEntity updateService(Long id, CertificateServiceEntity service) {
        return serviceRepository.findById(id).map(existing -> {
            existing.setName(service.getName());
            existing.setServiceSummary(service.getServiceSummary());
            existing.setApplicationMode(service.getApplicationMode());
            existing.setUrl(service.getUrl());
            existing.setOfficeAddress(service.getOfficeAddress());
            existing.setEligibility(service.getEligibility());
            existing.setShortForm(service.getShortForm());
            return serviceRepository.save(existing);
        }).orElse(null);
    }
    @Override
    public boolean deleteService(Long id) {
    if (serviceRepository.existsById(id)) {
        serviceRepository.deleteById(id);
        return true;
    }
    return false;
}


    @Override
    public boolean isServiceExists(String serviceName) {
        return serviceRepository.existsByName(serviceName);
    }

    @Override
    public boolean isServicePublished(Long id) {
        return serviceRepository.findById(id)
                .map(service -> service.getUrl() != null && !service.getUrl().isEmpty())
                .orElse(false);
    }
}
