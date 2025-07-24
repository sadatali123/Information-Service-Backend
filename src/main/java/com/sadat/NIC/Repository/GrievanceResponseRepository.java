package com.sadat.NIC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.GrievanceResponse;

public interface GrievanceResponseRepository extends JpaRepository<GrievanceResponse, Long> { 
    List<GrievanceResponse> findAllByGrievance_Id(Long grievanceId);
}
