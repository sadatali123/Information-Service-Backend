package com.sadat.NIC.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "scheme-contact-person")
public class SchemeContactPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name ="scheme-name")
    String schemeName;

    @Column(name = "Level")
    String level;

    @Column(name = "person_Name")
    String personName;

    @Column(name = "Designation")
    String designation;

    @Column(name = "Contact_No")
    Long contactNo;

    @Column(name = "Email_id")
    String email;

    @Column(name = "is_Active")
    Boolean isActive;

}
