package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.ContactPost;

public interface ContactPostService {
    ContactPost add(ContactPost post);
    ContactPost update(Long id, ContactPost updatedPost);
    List<ContactPost> getAll();
    ContactPost getById(Long id);
}
