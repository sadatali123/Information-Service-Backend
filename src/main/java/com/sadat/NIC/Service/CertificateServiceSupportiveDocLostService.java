package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocLostEntity;



public interface CertificateServiceSupportiveDocLostService {
    List<CertificateServiceSupportiveDocLostEntity> getAllSupportiveDoc();
    CertificateServiceSupportiveDocLostEntity getSupportiveDocById(Long id);
    CertificateServiceSupportiveDocLostEntity createSupportiveDoc(CertificateServiceSupportiveDocLostEntity entity);
    CertificateServiceSupportiveDocLostEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocLostEntity entity);
    void deleteSupportiveDoc(Long id);
}
