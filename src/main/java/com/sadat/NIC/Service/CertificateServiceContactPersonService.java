package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.CertificateServiceContactPersonEntity;


public interface CertificateServiceContactPersonService {
    List<CertificateServiceContactPersonEntity> getAllContactPerson();
    CertificateServiceContactPersonEntity getContactPersonById(Long id);
    CertificateServiceContactPersonEntity createContactPerson(CertificateServiceContactPersonEntity entity);
    CertificateServiceContactPersonEntity updateContactPerson(Long id, CertificateServiceContactPersonEntity entity);
    void deleteContactPerson(Long id);
}
