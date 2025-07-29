package com.sadat.NIC.Service.Impl;


import com.sadat.NIC.Entity.ContactOffice;
import com.sadat.NIC.Repository.ContactOfficeRepository;
import com.sadat.NIC.Service.ContactOfficeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactOfficeServiceImpl implements ContactOfficeService {

    @Autowired
    private ContactOfficeRepository OfficeRepository;

    @Override
    public ContactOffice add(ContactOffice office) {
        return OfficeRepository.save(office);
    }

    @Override
    public ContactOffice update(Long id, ContactOffice updatedOffice) {
        ContactOffice existing = OfficeRepository.findById(id).orElseThrow();
        existing.setOfficeName(updatedOffice.getOfficeName());
        existing.setLevel(updatedOffice.getLevel());
        existing.setPostOffice(updatedOffice.getPostOffice());
        existing.setPoliceStation(updatedOffice.getPoliceStation());
        existing.setDepartment(updatedOffice.getDepartment());
        return OfficeRepository.save(existing);
    }

    @Override
    public List<ContactOffice> getAll() {
        return OfficeRepository.findAll();
    }

    @Override
    public ContactOffice getById(Long id) {
        return OfficeRepository.findById(id).orElseThrow();
    }
}

