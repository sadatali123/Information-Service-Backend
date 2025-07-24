package com.sadat.NIC.Service.Impl;
import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceNewapplicationProcessEntity;
import com.sadat.NIC.Repository.CertificateServiceNewapplicationRepository;
import com.sadat.NIC.Service.CertificateServiceNewapplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CertificateServiceNewapplicationServiceImpl implements CertificateServiceNewapplicationService  {
    @Autowired
    private CertificateServiceNewapplicationRepository repository;

    @Override
    public List<CertificateServiceNewapplicationProcessEntity> getAllNewapplication() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceNewapplicationProcessEntity getNewapplicationById(Long id) {
        return repository.findById(id)
        .orElseThrow();
    }
    @Override
    public CertificateServiceNewapplicationProcessEntity createNewapplication(CertificateServiceNewapplicationProcessEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceNewapplicationProcessEntity updateNewapplication(Long id, CertificateServiceNewapplicationProcessEntity entity) {
        CertificateServiceNewapplicationProcessEntity existing = getNewapplicationById(id);
        existing.setServiceName(entity.getServiceName());
        existing.setStepNo(entity.getStepNo());
        existing.setStepDetails(entity.getStepDetails());
        return repository.save(existing);
    }

    @Override
    public void deleteNewapplication(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Application not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
