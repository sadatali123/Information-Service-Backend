package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.SchemeBenefits;


public interface SchemeBenefitsService {

    String demoService();

    SchemeBenefits createNewSchemeBenefits(SchemeBenefits schemeBenefits);

    List<SchemeBenefits> readAllSchemeBenefits();

    SchemeBenefits readAllSchemeBenefitsById(Long id);

    List<SchemeBenefits> readSchemeBenefitsBySchemeId(Long schemeId);

    SchemeBenefits updateSchemeBenefitsById(Long id, SchemeBenefits schemeBenefits);
    
}
