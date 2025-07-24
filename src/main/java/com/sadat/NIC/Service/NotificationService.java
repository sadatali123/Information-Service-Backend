package com.sadat.NIC.Service;

import com.sadat.NIC.Entity.Notification;
import com.sadat.NIC.Repository.NotificationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification saveNotification(Notification notification) {
        // Optionally set default fields like isRead and createdAt if not already set
        if (notification.getIsRead() == null) {
            notification.setIsRead(false);
        }
        if (notification.getCreatedAt() == null) {
            notification.setCreatedAt(java.time.LocalDateTime.now());
        }
        return notificationRepository.save(notification);
    }

    public void markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + id));
        notification.setIsRead(true);
        notificationRepository.save(notification);
    }
}
