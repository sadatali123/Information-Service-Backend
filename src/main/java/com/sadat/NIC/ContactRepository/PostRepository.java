package com.sadat.NIC.ContactRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sadat.NIC.ContactEntity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
