package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.CertificateServiceLostProcessEntity;
import java.util.List;

public interface CertificateServiceLostService {
    List<CertificateServiceLostProcessEntity> getAllLostProcess();
    CertificateServiceLostProcessEntity getLostProcessById(Long id);
    CertificateServiceLostProcessEntity createLostProcess(CertificateServiceLostProcessEntity entity);
    CertificateServiceLostProcessEntity updateLostProcess(Long id, CertificateServiceLostProcessEntity entity);
    void deleteLostProcess(Long id);
}
