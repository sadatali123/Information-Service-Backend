package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.Notification;
import com.sadat.NIC.Service.NotificationService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable("id") Long userId) {
        List<Notification> notifications = notificationService.getUserNotifications(userId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
         
    }

    @PostMapping("/user/{id}")
public ResponseEntity<Notification> createNotification(
        @PathVariable("id") Long userId,
        @RequestBody Notification notification) {

    // You may also want to set user and createdAt here
    Notification saved = notificationService.saveNotification(notification);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
}
}
