package com.sadat.NIC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadat.NIC.Entity.SchemeBenefits;
import com.sadat.NIC.Service.SchemeBenefitsService;




@RestController
@RequestMapping("/api/scheme-benefits")
@CrossOrigin(origins = "http://localhost:3000")
public class SchemeBenefitsController {
    @Autowired
    private SchemeBenefitsService schemeBenefitsService;
    

    @PostMapping("/create")
    public SchemeBenefits createSchemeBenefits(@RequestBody SchemeBenefits schemeBenefits){
        return schemeBenefitsService.createNewSchemeBenefits(schemeBenefits);
    }

    @GetMapping("/get-all-scheme-benefits")
    public List<SchemeBenefits> getAllSchemeBenefits(){
         List<SchemeBenefits> s = schemeBenefitsService.readAllSchemeBenefits();
        return s;
    }

    @GetMapping("/get-all-scheme-benefits/{Id}")
    public SchemeBenefits getSchemeBenefitsById(@PathVariable Long Id){
        SchemeBenefits c = schemeBenefitsService.readAllSchemeBenefitsById(Id);
        return c;
    }

    @GetMapping("/get-scheme-benefits/{schemeId}")
    public List<SchemeBenefits> getSchemeBenefitsBySchemeName(@PathVariable Long schemeId){
         List<SchemeBenefits> s = schemeBenefitsService.readSchemeBenefitsBySchemeId(schemeId);
        return s;
    }

     @PutMapping("/update-scheme-benefits/{id}")
    public ResponseEntity<SchemeBenefits> updateSchemeBenefitsById(@PathVariable Long id, @RequestBody SchemeBenefits schemeBenefits){
        return ResponseEntity.ok(schemeBenefitsService.updateSchemeBenefitsById(id, schemeBenefits));
    }
}
