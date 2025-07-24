package com.sadat.NIC.Service.Impl;
import com.sadat.NIC.DTO.C_DepartmentDetailsDTO;
import com.sadat.NIC.DTO.ContactEmployeeSummaryDTO;
import com.sadat.NIC.DTO.OfficeSummaryDTO;
import com.sadat.NIC.DTO.PostSummaryDTO;
import com.sadat.NIC.Entity.C_Department;
import com.sadat.NIC.Repository.ContactDepartmentRepository;
import com.sadat.NIC.Service.ContactDepartmentService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements ContactDepartmentService {

    @Autowired
    private ContactDepartmentRepository departmentRepository;

     @Override
    public C_Department add(C_Department dept) {
    Optional<C_Department> existing = departmentRepository.findByDeptNameAndType(dept.getDeptName(), dept.getType());
    if (existing.isPresent()) {
        throw new RuntimeException("Department already exists!");
    }
    return departmentRepository.save(dept);
    }  

    @Override
    public C_Department update(Long id, C_Department updatedDept) {
        C_Department existing = getById(id);
        existing.setDeptName(updatedDept.getDeptName());
        existing.setType(updatedDept.getType());
        return departmentRepository.save(existing);
    }

    @Override
    public List<C_Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public C_Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public C_Department togglePending(Long id) {
        C_Department dept = getById(id);
        dept.setPending(!dept.isPending());
        return departmentRepository.save(dept);
    }

    @Override
    public C_DepartmentDetailsDTO getDepartmentDetails(Long id) {
        C_Department dept = departmentRepository.findById(id).orElseThrow();

        List<PostSummaryDTO> postDTOs = dept.getPosts().stream().map(post -> new PostSummaryDTO(
            post.getId(),
            post.getPostName(),
            post.getRank()
        )).collect(Collectors.toList());

        List<ContactEmployeeSummaryDTO> employeeDTOs = dept.getEmployees().stream().map(emp -> new ContactEmployeeSummaryDTO(
            emp.getId(),
            emp.getName(),
            emp.getDesignation(),
            emp.getContactNumber(),
            emp.getEmail(),
            emp.isActive()
        )).collect(Collectors.toList());
        
           
        List<OfficeSummaryDTO> officeDTOs = dept.getOffices().stream().map(office -> new OfficeSummaryDTO(
            office.getId(),
            office.getOfficeName(),
            office.getLevel(),
            office.getPostOffice(),
            office.getPoliceStation(),
            office.getBlock(),
            office.getSubdivision(),
            office.getDistrict()
        )).collect(Collectors.toList());


        return new C_DepartmentDetailsDTO(
            dept.getId(),
            dept.getDeptName(),
            dept.getType(),
            dept.isPending(),
            postDTOs,
            employeeDTOs,
            officeDTOs
        );
    }


}