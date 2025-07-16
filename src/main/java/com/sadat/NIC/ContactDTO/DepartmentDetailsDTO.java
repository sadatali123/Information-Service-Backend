package com.sadat.NIC.ContactDTO;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDetailsDTO {
    private Long id;
    private String deptName;
    private String type;
    private boolean pending;
    private List<PostSummaryDTO> posts;
    private List<EmployeeSummaryDTO> employees;
    private List<OfficeSummaryDTO> offices;
}
