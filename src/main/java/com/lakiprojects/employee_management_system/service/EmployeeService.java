package com.lakiprojects.employee_management_system.service;

import com.lakiprojects.employee_management_system.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(int employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO searchEmployee(int employeeId);

    void updateEmployee(EmployeeDTO employeeDTO);
}
