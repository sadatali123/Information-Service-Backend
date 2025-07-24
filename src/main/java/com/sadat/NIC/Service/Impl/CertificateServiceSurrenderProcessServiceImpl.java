package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceSurrenderProcessEntity;
import com.sadat.NIC.Repository.CertificateServiceSurrenderProcessRepository;
import com.sadat.NIC.Service.CertificateServiceSurrenderProcessService;

@Service
public class CertificateServiceSurrenderProcessServiceImpl implements CertificateServiceSurrenderProcessService {

    @Autowired
    private CertificateServiceSurrenderProcessRepository repository;

    @Override
    public List<CertificateServiceSurrenderProcessEntity> getAllSurrenderProcess() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceSurrenderProcessEntity getSurrenderProcessById(Long id) {
        return repository.findById(id)
        .orElseThrow();
    }

    @Override
    public CertificateServiceSurrenderProcessEntity createSurrenderProcess(CertificateServiceSurrenderProcessEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceSurrenderProcessEntity updateSurrenderProcess(Long id, CertificateServiceSurrenderProcessEntity entity) {
        CertificateServiceSurrenderProcessEntity existing = getSurrenderProcessById(id);
        existing.setServiceName(entity.getServiceName());
        existing.setStepNo(entity.getStepNo());
        existing.setStepDetails(entity.getStepDetails());
        return repository.save(existing);
    }

    @Override
    public void deleteSurrenderProcess(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Surrender Process not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
