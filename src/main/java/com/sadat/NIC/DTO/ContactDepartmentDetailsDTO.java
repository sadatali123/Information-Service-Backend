package com.sadat.NIC.DTO;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDepartmentDetailsDTO {
    private Long id;
    private String deptName;
    private String type;
    private boolean pending;
    private List<ContactPostSummaryDTO> posts;
    private List<ContactEmployeeSummaryDTO> employees;
    private List<ContactOfficeSummaryDTO> offices;
}
