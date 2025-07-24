package com.sadat.NIC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.SchemeEligibility;



public interface SchemeEligibilityRepository extends JpaRepository<SchemeEligibility, Long> {
    
    List<SchemeEligibility> findBySchemeId(Long schemeId);
}
