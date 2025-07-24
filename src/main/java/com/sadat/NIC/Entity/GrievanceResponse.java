package com.sadat.NIC.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;




@Entity
@Table(name = "grievance_responses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrievanceResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="grievance_id")
    private Grievance grievance;

    @ManyToOne
    @JoinColumn(name="responder_id")
    private G_User responder;

    private String comment;
    private String actionTaken;

    private LocalDateTime createdAt = LocalDateTime.now();
}
