package com.sadat.NIC.DTO;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class C_DepartmentDetailsDTO {
    private Long id;
    private String deptName;
    private String type;
    private boolean pending;
    private List<PostSummaryDTO> posts;
    private List<ContactEmployeeSummaryDTO> employees;
    private List<OfficeSummaryDTO> offices;
}
