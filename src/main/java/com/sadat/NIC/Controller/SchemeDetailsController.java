package com.sadat.NIC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadat.NIC.Entity.SchemeDetails;
import com.sadat.NIC.Service.SchemeDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/api/scheme-details")
public class SchemeDetailsController {

    @Autowired
    private SchemeDetailsService schemeDetailsService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewScheme(@RequestBody SchemeDetails newSchemeDetails) {
        System.out.println("Received in controller: " + newSchemeDetails); 
        return ResponseEntity.ok(schemeDetailsService.createNewScheme(newSchemeDetails));
    }

    @GetMapping("/getall")
    public List<SchemeDetails> getAllSchemes() {
        List<SchemeDetails> s = schemeDetailsService.readAllSchemes();
        System.out.println("Get all schemes: " + s);
        return s;
    }

    @GetMapping("/get/{id}")
    public SchemeDetails getSchemeDetailsById(@PathVariable Long id) {
        return schemeDetailsService.readSchemeDetailsById(id);
    }

    @GetMapping("/name/{schemeName}")
    public SchemeDetails getSchemeDetailsByschemeName(@PathVariable String schemeName) {
        return schemeDetailsService.readSchemeDetailsBySchemeName(schemeName);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<SchemeDetails> updateSchemeDetails(@PathVariable Long id, @RequestBody SchemeDetails schemeDetails) {
        return ResponseEntity.ok(schemeDetailsService.updateSchemeDetailsById(id, schemeDetails));
    }

    @PutMapping("/change-published-status/{id}")
    public ResponseEntity<SchemeDetails> changePublishedStatus(@PathVariable Long id) {
        return ResponseEntity.ok(schemeDetailsService.changePublishedStatus(id));
    }

    @PutMapping("/change-active-status/{id}")
    public ResponseEntity<SchemeDetails> changeActiveStatus(@PathVariable Long id) {
        return ResponseEntity.ok(schemeDetailsService.changeActiveStatus(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteScheme(@PathVariable Long id) {
        schemeDetailsService.deleteSchemeById(id);
        return ResponseEntity.ok("Scheme deleted successfully");
    }
}
