package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.SchemeProcess;

import java.util.List;

public interface SchemeProcessRepository extends JpaRepository<SchemeProcess, Long> {

    List<SchemeProcess> findBySchemeId(Long schemeId);

    // Optional<List<SchemeProcess>> findBySchemeName(String schemeName);
    // Additional query methods can be defined here if needed
    
}
