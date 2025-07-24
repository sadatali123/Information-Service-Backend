package com.sadat.NIC.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSummaryDTO {
    private Long id;
    private String officeName;
    private String level;
    private String postOffice;
    private String policeStation;
    private String block;
    private String subdivision;
    private String district;
}
