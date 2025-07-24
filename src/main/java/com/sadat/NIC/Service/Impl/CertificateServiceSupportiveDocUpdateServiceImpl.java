package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceSupportiveDocUpdateEntity;
import com.sadat.NIC.Repository.CertificateServiceSupportiveDocUpdateRepository;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocUpdateService;

@Service
public class CertificateServiceSupportiveDocUpdateServiceImpl implements CertificateServiceSupportiveDocUpdateService  {
    @Autowired
    private CertificateServiceSupportiveDocUpdateRepository repository;

    @Override
    public List<CertificateServiceSupportiveDocUpdateEntity> getAllSupportiveDoc() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceSupportiveDocUpdateEntity getSupportiveDocById(Long id) {
        CertificateServiceSupportiveDocUpdateEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        return entity;
    }
    @Override
    public CertificateServiceSupportiveDocUpdateEntity createSupportiveDoc(CertificateServiceSupportiveDocUpdateEntity entity) {
        return repository.save(entity);
    }
    @Override
    public CertificateServiceSupportiveDocUpdateEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocUpdateEntity updatedEntity) {
        CertificateServiceSupportiveDocUpdateEntity existing = repository.findById(id).orElse(null);
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
