package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocUpdateEntity;

public interface CertificateServiceSupportiveDocUpdateService {
    List<CertificateServiceSupportiveDocUpdateEntity> getAllSupportiveDoc();
    CertificateServiceSupportiveDocUpdateEntity getSupportiveDocById(Long id);
    CertificateServiceSupportiveDocUpdateEntity createSupportiveDoc(CertificateServiceSupportiveDocUpdateEntity entity);
    CertificateServiceSupportiveDocUpdateEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocUpdateEntity entity);
    void deleteSupportiveDoc(Long id);
}
