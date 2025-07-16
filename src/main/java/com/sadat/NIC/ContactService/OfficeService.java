package com.sadat.NIC.ContactService;

import com.sadat.NIC.ContactEntity.Office;
import java.util.List;

public interface OfficeService {
    Office add(Office office);
    Office update(Long id, Office updatedOffice);
    List<Office> getAll();
    Office getById(Long id);
}
