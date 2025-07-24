package com.sadat.NIC.Service.Impl;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocLostEntity;
import com.sadat.NIC.Repository.CertificateServiceSupportiveDocLostRepository;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocLostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CertificateServiceSupportiveDocLostServiceImpl implements CertificateServiceSupportiveDocLostService  {
    @Autowired
    private CertificateServiceSupportiveDocLostRepository repository;

    @Override
    public List<CertificateServiceSupportiveDocLostEntity> getAllSupportiveDoc() {
        return repository.findAll();
    }
    @Override
    public CertificateServiceSupportiveDocLostEntity getSupportiveDocById(Long id) {
        CertificateServiceSupportiveDocLostEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        return entity;
    }
    @Override
    public CertificateServiceSupportiveDocLostEntity createSupportiveDoc(CertificateServiceSupportiveDocLostEntity entity) {
        return repository.save(entity);
    }
    @Override
    public CertificateServiceSupportiveDocLostEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocLostEntity updatedEntity) {
        CertificateServiceSupportiveDocLostEntity existing = repository.findById(id).orElse(null);
        if (existing == null) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        existing.setShortForm(updatedEntity.getShortForm());
        existing.setSlNo(updatedEntity.getSlNo());
        existing.setDoctype(updatedEntity.getDoctype());
        existing.setProofDoc(updatedEntity.getProofDoc());

        return repository.save(existing);
    }
    @Override
    public void deleteSupportiveDoc(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        repository.deleteById(id);
    }

}
