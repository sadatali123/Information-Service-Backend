package com.sadat.NIC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.SchemeBenefits;



public interface SchemeBenefitsRepository extends JpaRepository<SchemeBenefits, Long>{
    List<SchemeBenefits> findBySchemeId(Long schemeId);
}
