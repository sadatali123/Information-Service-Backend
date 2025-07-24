package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceUpdateProcessEntity;

public interface CertificateServiceUpdateService {
    List<CertificateServiceUpdateProcessEntity> getAllUpdateProcess();
    CertificateServiceUpdateProcessEntity getUpdateProcessById(Long id);
    CertificateServiceUpdateProcessEntity createUpdateProcess(CertificateServiceUpdateProcessEntity entity);
    CertificateServiceUpdateProcessEntity updateUpdateProcess(Long id, CertificateServiceUpdateProcessEntity entity);
    void deleteUpdateProcess(Long id);
}

