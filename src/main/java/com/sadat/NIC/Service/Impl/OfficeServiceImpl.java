package com.sadat.NIC.Service.Impl;


import com.sadat.NIC.Entity.Office;
import com.sadat.NIC.Repository.OfficeRepository;
import com.sadat.NIC.Service.OfficeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository OfficeRepository;

    @Override
    public Office add(Office office) {
        return OfficeRepository.save(office);
    }

    @Override
    public Office update(Long id, Office updatedOffice) {
        Office existing = OfficeRepository.findById(id).orElseThrow();
        existing.setOfficeName(updatedOffice.getOfficeName());
        existing.setLevel(updatedOffice.getLevel());
        existing.setPostOffice(updatedOffice.getPostOffice());
        existing.setPoliceStation(updatedOffice.getPoliceStation());
        existing.setDepartment(updatedOffice.getDepartment());
        return OfficeRepository.save(existing);
    }

    @Override
    public List<Office> getAll() {
        return OfficeRepository.findAll();
    }

    @Override
    public Office getById(Long id) {
        return OfficeRepository.findById(id).orElseThrow();
    }
}

