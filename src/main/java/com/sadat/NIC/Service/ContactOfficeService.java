package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.ContactOffice;

public interface ContactOfficeService {
    ContactOffice add(ContactOffice office);
    ContactOffice update(Long id, ContactOffice updatedOffice);
    List<ContactOffice> getAll();
    ContactOffice getById(Long id);
}
