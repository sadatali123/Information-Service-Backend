package com.sadat.NIC.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "attachments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long linkedEntityId; // For simplicity, store linked entity ID

    private String filePath;
    private String fileType;
    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "grievance_id", nullable = true)
    private Grievance grievance;
    // add more fields or relationships if needed
}
