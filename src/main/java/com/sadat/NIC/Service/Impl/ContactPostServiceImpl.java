package com.sadat.NIC.Service.Impl;

import com.sadat.NIC.Entity.ContactPost;
import com.sadat.NIC.Repository.ContactPostRepository;
import com.sadat.NIC.Service.ContactPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactPostServiceImpl implements ContactPostService {

    @Autowired
    private ContactPostRepository postRepository;

    @Override
    public ContactPost add(ContactPost post) {
        return postRepository.save(post);
    }

    @Override
    public ContactPost update(Long id, ContactPost updatedPost) {
        ContactPost existing = postRepository.findById(id).orElseThrow();
        existing.setPostName(updatedPost.getPostName());
        existing.setRank(updatedPost.getRank());
        existing.setDepartment(updatedPost.getDepartment());
        return postRepository.save(existing);
    }

    @Override
    public List<ContactPost> getAll() {
        return postRepository.findAll();
    }

    @Override
    public ContactPost getById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}

