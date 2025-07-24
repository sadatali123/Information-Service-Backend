package com.sadat.NIC.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import com.sadat.NIC.Entity.CertificateServiceSupportiveDocSurrenderEntity;
import com.sadat.NIC.Repository.CertificateServiceSupportiveDocSurrenderRepository;
import com.sadat.NIC.Service.CertificateServiceSupportiveDocSurrenderService;

@Service
public class CertificateServiceSupportiveDocSurrenderServiceImpl implements CertificateServiceSupportiveDocSurrenderService  {
    @Autowired
    private CertificateServiceSupportiveDocSurrenderRepository repository;

    @Override
    public List<CertificateServiceSupportiveDocSurrenderEntity> getAllSupportiveDoc() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceSupportiveDocSurrenderEntity getSupportiveDocById(Long id) {
        CertificateServiceSupportiveDocSurrenderEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Supportive Document not found with id: " + id);
        }
        return entity;
    }

    @Override
    public CertificateServiceSupportiveDocSurrenderEntity createSupportiveDoc(CertificateServiceSupportiveDocSurrenderEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceSupportiveDocSurrenderEntity updateSupportiveDoc(Long id, CertificateServiceSupportiveDocSurrenderEntity updatedEntity) {
        CertificateServiceSupportiveDocSurrenderEntity existing = repository.findById(id).orElse(null);
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
