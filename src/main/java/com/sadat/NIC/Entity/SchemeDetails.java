package com.sadat.NIC.Entity;

import com.sadat.NIC.enums.SchemeMode;
import com.sadat.NIC.enums.SchemeType;

// import java.time.LocalDate;


// import com.infoservice.schemeService.schemeEntities.enums.SchemeMode;
// import com.infoservice.schemeService.schemeEntities.enums.SchemeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "scheme-details")
public class SchemeDetails {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "scheme-name")
    String schemeName;
    
    @Column(name = "abbr")
    String abbr;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    SchemeType type;
    
    @Column(name = "summary")
    String summary;

    @Column(name = "target-audience")
    String targetAudience;

    @Column(name = "launch-date")    
    String launchDate;

    @Column(name = "is-published")
    Boolean isPublished;

    @Column(name = "is-active")
    Boolean isActive;

    @Column(name = "application-url", nullable = false)
    String applicationUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode")
    SchemeMode mode = SchemeMode.ONLINE;

    @Column(name = "office-address")
    String officeAddress;
}
