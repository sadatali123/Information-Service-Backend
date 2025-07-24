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

import com.sadat.NIC.Entity.SchemeEligibility;
import com.sadat.NIC.Service.SchemeEligibilityService;


@RestController
@RequestMapping("/api/scheme-eligibility")
@CrossOrigin(origins = "http://localhost:3000")
public class SchemeEligibilityController {

    @Autowired
    private SchemeEligibilityService schemeEligibilityService;

    @GetMapping("/demo")
    public String demoController() {
        return "Hello Controller" + schemeEligibilityService.demoService();
    }

    @PostMapping("/create")
    public SchemeEligibility createSchemeEligibility(@RequestBody SchemeEligibility schemeEligibility) {
        return schemeEligibilityService.createNewSchemeEligibility(schemeEligibility);
    }

    @GetMapping("/get-all-scheme-eligibility")
    public List<SchemeEligibility> getAllSchemeEligibility() {
        List<SchemeEligibility> c = schemeEligibilityService.readAllSchemeEligibility();
        return c;
    }

    @GetMapping("/get-eligibility-by-id/{id}")
    public SchemeEligibility getSchemeEligibilityBySchemeId(@PathVariable Long id) {
        SchemeEligibility s = schemeEligibilityService.getEligibilityById(id);
        return s;
    }

    @GetMapping("/get-scheme-eligibility/{schemeId}")
    public List<SchemeEligibility> get(@PathVariable Long schemeId) {
        List<SchemeEligibility> s = schemeEligibilityService.getSchemeEligibilityById(schemeId);
        return s;
    }

    @PutMapping("/update-scheme-eligibility/{id}")
    public ResponseEntity<SchemeEligibility> updateSchemeEligibility(@PathVariable Long id,
            @RequestBody SchemeEligibility schemeEligibility) {
        return ResponseEntity.ok(schemeEligibilityService.updateSchemeEligibilityById(id, schemeEligibility));
    }

}
