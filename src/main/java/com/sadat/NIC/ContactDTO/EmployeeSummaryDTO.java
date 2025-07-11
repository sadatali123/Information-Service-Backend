package com.sadat.NIC.ContactDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSummaryDTO {
    private Long id;
    private String name;
    private String designation;
    private String contact;
    private String email;
    private boolean isActive;
}
