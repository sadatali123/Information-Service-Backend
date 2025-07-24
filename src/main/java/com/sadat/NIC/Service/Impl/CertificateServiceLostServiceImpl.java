package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceLostProcessEntity;
import com.sadat.NIC.Repository.CertificateServiceLostRepository;
import com.sadat.NIC.Service.CertificateServiceLostService;

@Service
public class CertificateServiceLostServiceImpl implements CertificateServiceLostService {
    @Autowired
    private CertificateServiceLostRepository repository;

    @Override
    public List<CertificateServiceLostProcessEntity> getAllLostProcess() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceLostProcessEntity getLostProcessById(Long id) {
        return repository.findById(id)
        .orElseThrow();
    }

    @Override
    public CertificateServiceLostProcessEntity createLostProcess(CertificateServiceLostProcessEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceLostProcessEntity updateLostProcess(Long id, CertificateServiceLostProcessEntity updatedEntity) {
        CertificateServiceLostProcessEntity existing = getLostProcessById(id);
        existing.setServiceName(updatedEntity.getServiceName());
        existing.setStepNo(updatedEntity.getStepNo());
        existing.setStepDetails(updatedEntity.getStepDetails());
        return repository.save(existing);
    }

    @Override
    public void deleteLostProcess(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Lost Process not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
