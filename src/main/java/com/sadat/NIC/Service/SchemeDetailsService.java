package com.sadat.NIC.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sadat.NIC.Entity.SchemeDetails;


public interface SchemeDetailsService {
    String demoService();
    ResponseEntity<?> createNewScheme(SchemeDetails newSchemeDetails);

    List<SchemeDetails> readAllSchemes();
    // String readSchemeDetailsById(Long id);
    SchemeDetails readSchemeDetailsById(Long id);
    SchemeDetails readSchemeDetailsBySchemeName(String schemeName);
    SchemeDetails updateSchemeDetailsById(Long id, SchemeDetails schemaDetails);
    SchemeDetails changePublishedStatus(Long id);
    SchemeDetails changeActiveStatus(Long id);

    Boolean isSchemeExist(String schemeName);

    void deleteSchemeById(Long id);
}
