package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.Office;

public interface OfficeService {
    Office add(Office office);
    Office update(Long id, Office updatedOffice);
    List<Office> getAll();
    Office getById(Long id);
}
