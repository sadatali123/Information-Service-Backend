package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.CertificateServiceContactPersonEntity;
import com.sadat.NIC.Repository.CertificateServiceContactPersonRepository;
import com.sadat.NIC.Service.CertificateServiceContactPersonService;

@Service
public class CertificateServiceContactPersonServiceImpl implements CertificateServiceContactPersonService {
    @Autowired
    private CertificateServiceContactPersonRepository repository;

    @Override
    public List<CertificateServiceContactPersonEntity> getAllContactPerson() {
        return repository.findAll();
    }

    @Override
    public CertificateServiceContactPersonEntity getContactPersonById(Long id) {
        return repository.findById(id)
        .orElseThrow();
    }

    @Override
    public CertificateServiceContactPersonEntity createContactPerson(CertificateServiceContactPersonEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CertificateServiceContactPersonEntity updateContactPerson(Long id, CertificateServiceContactPersonEntity updatedEntity) {
        CertificateServiceContactPersonEntity existing = repository.findById(id)
            .orElseThrow();

        existing.setServiceName(updatedEntity.getServiceName());
        existing.setDistrict(updatedEntity.getDistrict());
        existing.setSubDivision(updatedEntity.getSubDivision());
        existing.setBlock(updatedEntity.getBlock());
        existing.setOfficeAddress(updatedEntity.getOfficeAddress());
        existing.setEmployeeDesignation(updatedEntity.getEmployeeDesignation());
        existing.setEmployeeDesignation(updatedEntity.getEmployeeDesignation());
        existing.setEmail(updatedEntity.getEmail());
        existing.setContact(updatedEntity.getContact());

        return repository.save(existing);
    }

    @Override
    public void deleteContactPerson(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Contact Person not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
