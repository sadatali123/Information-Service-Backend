package com.sadat.NIC.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class G_Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean isActive;

    @OneToMany(mappedBy = "department")
    private List<Grievance> grievances;
}