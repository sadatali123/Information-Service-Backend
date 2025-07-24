package com.sadat.NIC.Service.Impl;

import com.sadat.NIC.Entity.Post;
import com.sadat.NIC.Repository.PostRepository;
import com.sadat.NIC.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Long id, Post updatedPost) {
        Post existing = postRepository.findById(id).orElseThrow();
        existing.setPostName(updatedPost.getPostName());
        existing.setRank(updatedPost.getRank());
        existing.setDepartment(updatedPost.getDepartment());
        return postRepository.save(existing);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}

