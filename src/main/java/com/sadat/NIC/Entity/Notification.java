package com.sadat.NIC.Entity;
import lombok.*;
import jakarta.persistence.*;   
import java.time.LocalDateTime;


import com.sadat.NIC.Entity.Notification;




@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="g_user")
    private G_User user;

    @ManyToOne
    @JoinColumn(name="grievance_id", nullable=true)
    private Grievance grievance;
    ;

    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        if (isRead == null) isRead = false;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }
}