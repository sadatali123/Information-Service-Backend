package com.sadat.NIC.ContactEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact-office-details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String officeName;
    private String level;
    private String postOffice;
    private String policeStation;
    private String block;
    private String subdivision;
    private String district;



    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}

