package com.sadat.NIC.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class G_User {
    public enum Role { CITIZEN, OFFICER, ADMIN }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.isActive = this.isActive == null ? true : this.isActive;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user")
    private List<Grievance> grievances;

    @OneToMany(mappedBy = "responder")
    private List<GrievanceResponse> responses;

    // @OneToMany(mappedBy = "user")
    // private List<EmergencyReport> emergencyReports;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
}
