package com.sadat.NIC.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "grievances")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grievance {
    public enum Status {
        SUBMITTED, IN_PROGRESS, RESOLVED, DISMISSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private G_User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private G_Department department;

    private String subject;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Boolean isAnonymous;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.isAnonymous = this.isAnonymous == null ? true : this.isAnonymous;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "grievance")
    private List<GrievanceResponse> responses;

    @OneToMany(mappedBy = "grievance")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "grievance")
    private List<Attachment> attachments;
}