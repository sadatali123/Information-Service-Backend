package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.SchemeProcess;


public interface SchemeProcessService {
    String demoService();

    SchemeProcess createNewSchemeProcess(SchemeProcess schemeProcess);

    List<SchemeProcess> readAllSchemeProcess();

    SchemeProcess readAllSchemeProcessById(Long id);

    // List<SchemeProcess> readSchemeProcessBySchemeName(String schemeName);

    SchemeProcess updateSchemeProcessById(Long id, SchemeProcess schemeProcess);

    List<SchemeProcess> getSchemeProcessById(Long schemeId);
}
