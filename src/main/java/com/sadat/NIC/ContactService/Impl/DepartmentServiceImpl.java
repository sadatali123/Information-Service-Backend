package com.sadat.NIC.ContactService.Impl;

import com.sadat.NIC.ContactEntity.Department;
import com.sadat.NIC.ContactService.DepartmentService;
import com.sadat.NIC.ContactRepository.DepartmentRepository;
import com.sadat.NIC.ContactDTO.DepartmentDetailsDTO;
import com.sadat.NIC.ContactDTO.PostSummaryDTO;
import com.sadat.NIC.ContactDTO.EmployeeSummaryDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

     @Override
    public Department add(Department dept) {
    Optional<Department> existing = departmentRepository.findByDeptNameAndType(dept.getDeptName(), dept.getType());
    if (existing.isPresent()) {
        throw new RuntimeException("Department already exists!");
    }
    return departmentRepository.save(dept);
    }  

    @Override
    public Department update(Long id, Department updatedDept) {
        Department existing = getById(id);
        existing.setDeptName(updatedDept.getDeptName());
        existing.setType(updatedDept.getType());
        return departmentRepository.save(existing);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public Department togglePending(Long id) {
        Department dept = getById(id);
        dept.setPending(!dept.isPending());
        return departmentRepository.save(dept);
    }

    @Override
    public DepartmentDetailsDTO getDepartmentDetails(Long id) {
        Department dept = departmentRepository.findById(id).orElseThrow();

        List<PostSummaryDTO> postDTOs = dept.getPosts().stream().map(post -> new PostSummaryDTO(
            post.getId(),
            post.getPostName(),
            post.getLevel(),
            post.getOfficeName(),
            post.getOfficeAddress()
        )).collect(Collectors.toList());

        List<EmployeeSummaryDTO> employeeDTOs = dept.getEmployees().stream().map(emp -> new EmployeeSummaryDTO(
            emp.getId(),
            emp.getName(),
            emp.getDesignation(),
            emp.getContact(),
            emp.getEmail(),
            emp.isActive()
        )).collect(Collectors.toList());

        return new DepartmentDetailsDTO(
            dept.getId(),
            dept.getDeptName(),
            dept.getType(),
            dept.isPending(),
            postDTOs,
            employeeDTOs
        );
    }


}