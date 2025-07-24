package com.sadat.NIC.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEmployeeSummaryDTO {
    private Long id;
    private String name;
    private String designation;
    private Integer contactNumber;
    private String email;
    private boolean isActive;
}
