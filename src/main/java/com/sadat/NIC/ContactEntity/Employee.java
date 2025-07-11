package com.sadat.NIC.ContactEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact-employee-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private String contact;
    private String email;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}

