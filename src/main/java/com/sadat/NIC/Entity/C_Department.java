package com.sadat.NIC.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "contact-department-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class C_Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;
    private String type;
    private boolean isPending;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<ContactEmployee> employees;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Office> offices; 
}
