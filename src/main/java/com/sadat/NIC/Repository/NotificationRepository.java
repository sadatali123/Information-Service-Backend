package com.sadat.NIC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadat.NIC.Entity.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
}
