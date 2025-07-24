package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceNewapplicationProcessEntity;


public interface CertificateServiceNewapplicationService {
    List<CertificateServiceNewapplicationProcessEntity> getAllNewapplication();
    CertificateServiceNewapplicationProcessEntity getNewapplicationById(Long id);
    CertificateServiceNewapplicationProcessEntity createNewapplication(CertificateServiceNewapplicationProcessEntity entity);
    CertificateServiceNewapplicationProcessEntity updateNewapplication(Long id, CertificateServiceNewapplicationProcessEntity entity);
    void deleteNewapplication(Long id);
}
