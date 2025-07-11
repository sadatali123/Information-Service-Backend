package com.sadat.NIC.ContactEntity;

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
    private String level;
    private String officeName;
    private String officeAddress;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}

