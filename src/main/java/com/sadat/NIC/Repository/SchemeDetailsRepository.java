package com.sadat.NIC.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.SchemeDetails;


public interface SchemeDetailsRepository extends JpaRepository<SchemeDetails, Long>{

    Optional<SchemeDetails> findBySchemeName(String schemeName);

}
