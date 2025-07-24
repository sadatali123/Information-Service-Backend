package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
