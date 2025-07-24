package com.sadat.NIC.Service;

import java.util.List;
import com.sadat.NIC.Entity.CertificateServiceSurrenderProcessEntity;


public interface CertificateServiceSurrenderProcessService {
    List<CertificateServiceSurrenderProcessEntity> getAllSurrenderProcess();
    CertificateServiceSurrenderProcessEntity getSurrenderProcessById(Long id);
    CertificateServiceSurrenderProcessEntity createSurrenderProcess(CertificateServiceSurrenderProcessEntity entity);
    CertificateServiceSurrenderProcessEntity updateSurrenderProcess(Long id, CertificateServiceSurrenderProcessEntity entity);
    void deleteSurrenderProcess(Long id);
}
