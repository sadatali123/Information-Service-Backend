package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.G_Department;
import com.sadat.NIC.Repository.G_DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class G_DepartmentService {
    private final G_DepartmentRepository departmentRepository;

    public G_DepartmentService(G_DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<G_Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<G_Department> getById(Long id) {
        return departmentRepository.findById(id);
    }

    public G_Department addDepartment(G_Department department) {
        return departmentRepository.save(department);
    }

    public G_Department updateDepartment(Long id, G_Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        }
    }
} 