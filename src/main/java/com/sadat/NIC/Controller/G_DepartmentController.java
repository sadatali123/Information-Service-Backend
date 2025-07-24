package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.G_Department;
import com.sadat.NIC.Service.G_DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class G_DepartmentController {

    private final G_DepartmentService departmentService;

    public G_DepartmentController(G_DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<G_Department>> getAll() {
        List<G_Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<G_Department> getById(@PathVariable Long id) {
        return departmentService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<G_Department> add(@RequestBody G_Department dept) {
        G_Department savedDepartment = departmentService.addDepartment(dept);
        return ResponseEntity.ok(savedDepartment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<G_Department> update(@PathVariable Long id, @RequestBody G_Department dept) {
        G_Department updatedDepartment = departmentService.updateDepartment(id, dept);
        if (updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}