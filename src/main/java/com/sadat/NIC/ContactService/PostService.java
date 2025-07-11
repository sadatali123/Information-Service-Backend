package com.sadat.NIC.ContactService;

import com.sadat.NIC.ContactEntity.Post;

import java.util.List;

public interface PostService {
    Post add(Post post);
    Post update(Long id, Post updatedPost);
    List<Post> getAll();
    Post getById(Long id);
}
