package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
}