package com.sadat.NIC.Service.Impl;
import com.sadat.NIC.DTO.ContactDepartmentDetailsDTO;
import com.sadat.NIC.DTO.ContactEmployeeSummaryDTO;
import com.sadat.NIC.DTO.ContactOfficeSummaryDTO;
import com.sadat.NIC.DTO.ContactPostSummaryDTO;
import com.sadat.NIC.Entity.ContactDepartment;
import com.sadat.NIC.Repository.ContactDepartmentRepository;
import com.sadat.NIC.Service.ContactDepartmentService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactDepartmentServiceImpl implements ContactDepartmentService {

    @Autowired
    private ContactDepartmentRepository departmentRepository;

     @Override
    public ContactDepartment add(ContactDepartment dept) {
    Optional<ContactDepartment> existing = departmentRepository.findByDeptNameAndType(dept.getDeptName(), dept.getType());
    if (existing.isPresent()) {
        throw new RuntimeException("Department already exists!");
    }
    return departmentRepository.save(dept);
    }  

    @Override
    public ContactDepartment update(Long id, ContactDepartment updatedDept) {
        ContactDepartment existing = getById(id);
        existing.setDeptName(updatedDept.getDeptName());
        existing.setType(updatedDept.getType());
        return departmentRepository.save(existing);
    }

    @Override
    public List<ContactDepartment> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public ContactDepartment getById(Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public ContactDepartment togglePending(Long id) {
        ContactDepartment dept = getById(id);
        dept.setPending(!dept.isPending());
        return departmentRepository.save(dept);
    }

    @Override
    public ContactDepartmentDetailsDTO getDepartmentDetails(Long id) {
        ContactDepartment dept = departmentRepository.findById(id).orElseThrow();

        List<ContactPostSummaryDTO> postDTOs = dept.getPosts().stream().map(post -> new ContactPostSummaryDTO(
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
        
           
        List<ContactOfficeSummaryDTO> officeDTOs = dept.getOffices().stream().map(office -> new ContactOfficeSummaryDTO(
            office.getId(),
            office.getOfficeName(),
            office.getLevel(),
            office.getPostOffice(),
            office.getPoliceStation(),
            office.getBlock(),
            office.getSubdivision(),
            office.getDistrict()
        )).collect(Collectors.toList());


        return new ContactDepartmentDetailsDTO(
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