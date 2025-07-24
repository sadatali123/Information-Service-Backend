package com.sadat.NIC.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadat.NIC.Entity.SchemeBenefits;
import com.sadat.NIC.Repository.SchemeBenefitsRepository;
import com.sadat.NIC.Service.SchemeBenefitsService;


@Service
public class SchemeBenefitsServiceimpl  implements SchemeBenefitsService {

    @Autowired
    private SchemeBenefitsRepository schemeBenefitsRepository;

    @Override
    public String demoService() {
        return "Hello Seheme Benefits Service";
    }

    @Override
    public SchemeBenefits createNewSchemeBenefits(SchemeBenefits newSchemeBenefits) {
        SchemeBenefits schemeBenefits = schemeBenefitsRepository.save(newSchemeBenefits);
       return schemeBenefits;
    }

    @Override
    public List<SchemeBenefits> readAllSchemeBenefits() {
        List<SchemeBenefits> schemeBenefitsList = schemeBenefitsRepository.findAll();
        return schemeBenefitsList;
    }

    @Override
    public SchemeBenefits readAllSchemeBenefitsById(Long id) {
        return schemeBenefitsRepository.findById(id).orElse(null);
    }

    @Override
    public List<SchemeBenefits> readSchemeBenefitsBySchemeId(Long schemeId) {
        List<SchemeBenefits> ss = schemeBenefitsRepository.findBySchemeId(schemeId);
        return ss;
    }

    @Override
    public SchemeBenefits updateSchemeBenefitsById(Long id, SchemeBenefits updateBenefits) {
        SchemeBenefits existingBenefits = readAllSchemeBenefitsById(id);
        existingBenefits.setBenefits(updateBenefits.getBenefits());
        return schemeBenefitsRepository.save(existingBenefits);
    }
    
}
