package com.sadat.NIC.Service;

import java.util.List;

import com.sadat.NIC.Entity.Post;

public interface PostService {
    Post add(Post post);
    Post update(Long id, Post updatedPost);
    List<Post> getAll();
    Post getById(Long id);
}
