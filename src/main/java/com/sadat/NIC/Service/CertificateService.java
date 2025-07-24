package com.sadat.NIC.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sadat.NIC.Entity.CertificateServiceEntity;

public interface CertificateService {
    List<CertificateServiceEntity> getAllServices();
    CertificateServiceEntity getServiceById(Long id);
    ResponseEntity<?> createService(CertificateServiceEntity service);
    CertificateServiceEntity updateService(Long id, CertificateServiceEntity service);
    boolean deleteService(Long id);
    boolean isServiceExists(String serviceName);
    boolean isServicePublished(Long id);
}
