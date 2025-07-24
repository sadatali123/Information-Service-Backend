package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.G_User;

import java.util.Optional;

public interface G_UserRepository extends JpaRepository<G_User, Long> {
    Optional<G_User> findByEmail(String email);
}


