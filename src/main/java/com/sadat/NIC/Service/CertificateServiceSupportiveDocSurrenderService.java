package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocSurrenderEntity;

public interface CertificateServiceSupportiveDocSurrenderService {
    List<CertificateServiceSupportiveDocSurrenderEntity> getAllSupportiveDoc();
    CertificateServiceSupportiveDocSurrenderEntity getSupportiveDocById(Long id);
    CertificateServiceSupportiveDocSurrenderEntity createSupportiveDoc(CertificateServiceSupportiveDocSurrenderEntity entity);
    CertificateServiceSupportiveDocSurrenderEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocSurrenderEntity entity);
    void deleteSupportiveDoc(Long id);
}
