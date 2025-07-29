package com.sadat.NIC.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact-employee-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private Integer contactNumber;
    private String email;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private ContactDepartment department;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private ContactPost post;
}

