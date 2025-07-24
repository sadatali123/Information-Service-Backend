package com.sadat.NIC.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact-post-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postName;
    private String rank;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private C_Department department;
}

