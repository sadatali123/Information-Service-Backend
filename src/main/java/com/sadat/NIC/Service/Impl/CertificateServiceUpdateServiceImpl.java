package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceUpdateProcessEntity;
import com.sadat.NIC.Repository.CertificateServiceUpdateRepository;
import com.sadat.NIC.Service.CertificateServiceUpdateService;

@Service
public class CertificateServiceUpdateServiceImpl implements CertificateServiceUpdateService {
    @Autowired
    private CertificateServiceUpdateRepository repository;

    @Override
    public List<CertificateServiceUpdateProcessEntity> getAllUpdateProcess() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceUpdateProcessEntity getUpdateProcessById(Long id) {
        return repository.findById(id)
        .orElseThrow();
    }

    @Override
    public CertificateServiceUpdateProcessEntity createUpdateProcess(CertificateServiceUpdateProcessEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceUpdateProcessEntity updateUpdateProcess(Long id, CertificateServiceUpdateProcessEntity updatedEntity) {
        CertificateServiceUpdateProcessEntity existing = getUpdateProcessById(id);
        existing.setServiceName(updatedEntity.getServiceName());
        existing.setStepNo(updatedEntity.getStepNo());
        existing.setStepDetails(updatedEntity.getStepDetails());
        return repository.save(existing);
    }

    @Override
    public void deleteUpdateProcess(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Update Process not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
