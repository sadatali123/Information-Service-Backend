package com.sadat.NIC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadat.NIC.Entity.SchemeContactPerson;
import com.sadat.NIC.Service.SchemeContactPersonService;


@RestController
@RequestMapping("/api/scheme-contact-person")
@CrossOrigin(origins = "http://localhost:5173")
public class SchemeContactPersonController {
    
    @Autowired
    private SchemeContactPersonService schemeContactPersonService;

    @GetMapping("/demo")
    public String demoController(){
        return "Hello Controller" + schemeContactPersonService.demoService();
    }  
    
    @PostMapping("/create")
    public ResponseEntity<?>  creatSchemeContactPerson(@RequestBody SchemeContactPerson newSchemeContactPerson){
         return ResponseEntity.ok(schemeContactPersonService.createNewSchemeContactPerson(newSchemeContactPerson));
    }


    @GetMapping("/get-all-scheme-contact-person")
     public List<SchemeContactPerson> getAllSchemeContactPerson(){
        List<SchemeContactPerson> s = schemeContactPersonService.readAllSchemeContactPerson();
        return s;
    }

    @GetMapping("/get-all-scheme-contact-person/{Id}")
    public SchemeContactPerson getSchemeContactPersonById(@PathVariable Long Id){
        SchemeContactPerson c = schemeContactPersonService.readAllSchemeContactPersonById(Id);
        return c;
    }

    @GetMapping("/get-scheme-contact-person/{schemeName}")
    public SchemeContactPerson getSchemeContactPersonBySchemeName(@PathVariable String schemeName){
        SchemeContactPerson s = schemeContactPersonService.readSchemeContactPersonBySchemeName(schemeName);
        return s;
    }

    @PutMapping("/update-scheme-contact-person/{id}")
    public ResponseEntity<SchemeContactPerson> updateSchemeContactPersonById(@PathVariable Long id,@RequestBody SchemeContactPerson schemeContactPerson){
        return ResponseEntity.ok(schemeContactPersonService.updateSchemeContactPersonById(id, schemeContactPerson));
    }

    @PutMapping("/change-active-status/{id}")
    public ResponseEntity<SchemeContactPerson> changeActiveStatus(@PathVariable Long id) {
        return ResponseEntity.ok(schemeContactPersonService.changeActiveStatus(id));
    }

}
