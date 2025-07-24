package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.SchemeContactPerson;
import com.sadat.NIC.Repository.SchemeContactPersonRepository;
import com.sadat.NIC.Service.SchemeContactPersonService;



@Service
public class SchemeContactPersonServiceimpl implements SchemeContactPersonService{

    @Autowired
    private SchemeContactPersonRepository schemeContactPersonRepository;

    @Override
    public String demoService() {
        return "Hello Seheme Contact Person Service";
    }

    @Override
    public ResponseEntity<?> createNewSchemeContactPerson(SchemeContactPerson newSchemeContactPerson) {
        if (isSchemeExist(newSchemeContactPerson.getSchemeName()))  {
            return ResponseEntity.badRequest().body("Scheme with name " + newSchemeContactPerson.getSchemeName() + " already exists.");
        }
        newSchemeContactPerson.setIsActive(false);

        return ResponseEntity.ok(schemeContactPersonRepository.save(newSchemeContactPerson));

        // SchemeContactPerson schemeContactPerson = schemeContactPersonRepository.save(newSchemeContactPerson);
        // return schemeContactPerson;
    }

    
    @Override
    public List<SchemeContactPerson> readAllSchemeContactPerson() {
        List<SchemeContactPerson> schemeContactPersonList = schemeContactPersonRepository.findAll();
        return schemeContactPersonList;
    }
    
    @Override
    public SchemeContactPerson readAllSchemeContactPersonById(Long id) {
        return schemeContactPersonRepository.findById(id).orElse(null);
    }

    @Override
    public SchemeContactPerson readSchemeContactPersonBySchemeName(String schemeName) {
        SchemeContactPerson ss = schemeContactPersonRepository.findBySchemeName(schemeName).orElse(null);
        System.out.println(ss);
        return ss;
    }

    @Override
    public SchemeContactPerson updateSchemeContactPersonById(Long id, SchemeContactPerson  updateContactPerson) {
        SchemeContactPerson existingContactPerson = readAllSchemeContactPersonById(id);

        existingContactPerson.setSchemeName(updateContactPerson.getSchemeName());
        existingContactPerson.setLevel(updateContactPerson.getLevel());
        existingContactPerson.setPersonName(updateContactPerson.getPersonName());
        existingContactPerson.setDesignation(updateContactPerson.getDesignation());
        existingContactPerson.setContactNo(updateContactPerson.getContactNo());
        existingContactPerson.setEmail(updateContactPerson.getEmail());
        existingContactPerson.setIsActive(updateContactPerson.getIsActive());

        return schemeContactPersonRepository.save(existingContactPerson);
    }

    @Override
    public SchemeContactPerson changeActiveStatus(Long id) {
        SchemeContactPerson existingSchemeContactPerson = readAllSchemeContactPersonById(id);
        existingSchemeContactPerson.setIsActive(!existingSchemeContactPerson.getIsActive());
        return schemeContactPersonRepository.save(existingSchemeContactPerson);
    }
    
    @Override
    public Boolean isSchemeExist(String schemeName) {
        return (readSchemeContactPersonBySchemeName(schemeName) == null) ? false : true;
    }

    
}
