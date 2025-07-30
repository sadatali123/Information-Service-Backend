package com.sadat.NIC.DTO;

import com.sadat.NIC.enums.SchemeMode;
import com.sadat.NIC.enums.SchemeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchemeDetailsDTO {

    private Long id;
    private String schemeName;
    // private String abbr;
    private SchemeType type;
    private String summary;
    private String targetAudience;
    // private String launchDate;
    // private Boolean isPublished;
    // private Boolean isActive;
    private String applicationUrl;
    private SchemeMode mode;
    private String officeAddress;
}
