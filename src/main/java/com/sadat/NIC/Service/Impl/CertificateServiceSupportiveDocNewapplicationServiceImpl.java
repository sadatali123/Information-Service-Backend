package com.sadat.NIC.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sadat.NIC.Entity.CertificateServiceSupportiveDocNewapplicationEntity;
import com.sadat.NIC.Repository.CertificateServiceSupportiveDocNewapplicationRepository;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocNewapplicationService;

import java.util.List;

@Service
public class CertificateServiceSupportiveDocNewapplicationServiceImpl implements CertificateServiceSupportiveDocNewapplicationService {

    @Autowired
    private CertificateServiceSupportiveDocNewapplicationRepository repository;

    @Override
    public List<CertificateServiceSupportiveDocNewapplicationEntity> getAllSupportiveDoc() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceSupportiveDocNewapplicationEntity getSupportiveDocById(Long id) {
        CertificateServiceSupportiveDocNewapplicationEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        return entity;
    }

    @Override
    public CertificateServiceSupportiveDocNewapplicationEntity createSupportiveDoc(CertificateServiceSupportiveDocNewapplicationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceSupportiveDocNewapplicationEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocNewapplicationEntity updatedEntity) {
        CertificateServiceSupportiveDocNewapplicationEntity existing = repository.findById(id).orElse(null);
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
