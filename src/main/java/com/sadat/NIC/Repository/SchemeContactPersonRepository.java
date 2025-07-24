package com.sadat.NIC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.SchemeContactPerson;


public interface SchemeContactPersonRepository extends JpaRepository<SchemeContactPerson, Long>{

    Optional<SchemeContactPerson> findBySchemeName(String schemeName);
}
