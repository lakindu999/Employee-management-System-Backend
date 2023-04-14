package com.lakiprojects.employee_management_system.service.impl;

import com.lakiprojects.employee_management_system.DTO.EmployeeDTO;
import com.lakiprojects.employee_management_system.entity.Employee;
import com.lakiprojects.employee_management_system.repository.EmployeeRepo;
import com.lakiprojects.employee_management_system.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeRepo.save(employee);
        return (employeeDTO.getEmployeeName()+ "Saved as Employee");
    }

    @Override
    public void deleteEmployee(int employeeId) {
        if (employeeRepo.existsById(employeeId)){
            employeeRepo.deleteById(employeeId);
        }
        else {
            throw new RuntimeException("Employee Not Found");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.size()>0){
            List<EmployeeDTO> listEmployeeDTO = modelMapper.map(employees,new TypeToken<List<EmployeeDTO>>(){}.getType());
            return listEmployeeDTO;
        }
        else{
            throw new RuntimeException("No Employees Found");
        }
    }

    @Override
    public EmployeeDTO searchEmployee(int employeeId) {
        if (employeeRepo.existsById(employeeId)){
            Employee employee = employeeRepo.getReferenceById(employeeId);
            EmployeeDTO customerDTO = modelMapper.map(employee,EmployeeDTO.class);
            return customerDTO;
        }
        else{
            throw new RuntimeException("No Employee for ID " + employeeId);
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeId())){
            Employee employee = modelMapper.map(employeeDTO,Employee.class);
            employeeRepo.save(employee);
        }
        else {
            throw new RuntimeException("No Employee Found");
        }
    }
}
