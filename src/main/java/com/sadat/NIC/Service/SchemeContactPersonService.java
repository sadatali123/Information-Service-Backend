package com.sadat.NIC.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sadat.NIC.Entity.SchemeContactPerson;



public interface SchemeContactPersonService {

    String demoService();

    ResponseEntity<?> createNewSchemeContactPerson(SchemeContactPerson newSchemeContactPerson);

    List<SchemeContactPerson> readAllSchemeContactPerson();

    SchemeContactPerson readAllSchemeContactPersonById(Long id);

    SchemeContactPerson readSchemeContactPersonBySchemeName(String schemeName);

    SchemeContactPerson updateSchemeContactPersonById(Long id, SchemeContactPerson schemeContactPerson);

    SchemeContactPerson changeActiveStatus(Long id);

    Boolean isSchemeExist(String schemeName);

    // Object createNewSchemeContactPerson(SchemeContactPerson newSchemeContactPerson);
    
}
