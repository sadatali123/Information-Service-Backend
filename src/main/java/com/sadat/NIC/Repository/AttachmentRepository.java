package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.Attachment;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> { 
     List<Attachment> findByLinkedEntityId(Long linkedEntityId);
}
