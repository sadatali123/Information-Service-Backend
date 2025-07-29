package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.ContactPost;

public interface ContactPostRepository extends JpaRepository<ContactPost, Long> {
}
