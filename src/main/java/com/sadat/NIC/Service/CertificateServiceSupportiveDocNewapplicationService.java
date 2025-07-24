package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocNewapplicationEntity;


public interface CertificateServiceSupportiveDocNewapplicationService {
    List<CertificateServiceSupportiveDocNewapplicationEntity> getAllSupportiveDoc();
    CertificateServiceSupportiveDocNewapplicationEntity getSupportiveDocById(Long id);
    CertificateServiceSupportiveDocNewapplicationEntity createSupportiveDoc(CertificateServiceSupportiveDocNewapplicationEntity entity);
    CertificateServiceSupportiveDocNewapplicationEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocNewapplicationEntity entity);
    void deleteSupportiveDoc(Long id);
}
