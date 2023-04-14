package com.lakiprojects.employee_management_system.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private int employeeId;
    private String employeeName;
    private String employeeAddress;
    private int employeePhone;
}
