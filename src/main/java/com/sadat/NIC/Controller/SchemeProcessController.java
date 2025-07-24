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

import com.sadat.NIC.Entity.SchemeProcess;
import com.sadat.NIC.Service.SchemeProcessService;



@RestController
@RequestMapping("/api/scheme-process")
@CrossOrigin(origins = "http://localhost:5173")
public class SchemeProcessController {

    @Autowired
    private SchemeProcessService schemeProcessService;

    @GetMapping("/demo")
    public String demoController() {
        return "Hello Controller" + schemeProcessService.demoService();
    }

    @PostMapping("/create")
    public SchemeProcess createSchemeProcess(@RequestBody SchemeProcess schemeProcess) {
        return schemeProcessService.createNewSchemeProcess(schemeProcess);
    }

    @GetMapping("/get-all-scheme-process")
    public List<SchemeProcess> getAllSchemeProcess() {
        List<SchemeProcess> s = schemeProcessService.readAllSchemeProcess();
        return s;
    }

    @GetMapping("/get-all-scheme-process/{Id}")
    public SchemeProcess getSchemeProcessById(@PathVariable Long Id) {
        SchemeProcess c = schemeProcessService.readAllSchemeProcessById(Id);
        return c;
    }

    // @GetMapping("/get-scheme-process/{schemeName}")
    // public List<SchemeProcess> getSchemeProcessBySchemeName(@PathVariable String schemeName){
    //      List<SchemeProcess> s = schemeProcessService.readSchemeProcessBySchemeName(schemeName);
    //     return s;
    // }
    
    @GetMapping("/get-scheme-Process/{schemeId}")
    public List<SchemeProcess> get(@PathVariable Long schemeId) {
        List<SchemeProcess> s = schemeProcessService.getSchemeProcessById(schemeId);
        return s;
    }
    
    @PutMapping("/update-scheme-process/{id}")
    public ResponseEntity<SchemeProcess> updateSchemeProcessById(@PathVariable Long id,
            @RequestBody SchemeProcess schemeProcess) {
        return ResponseEntity.ok(schemeProcessService.updateSchemeProcessById(id, schemeProcess));
    }

}
