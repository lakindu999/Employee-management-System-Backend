package com.lakiprojects.employee_management_system.controller;

import com.lakiprojects.employee_management_system.DTO.EmployeeDTO;
import com.lakiprojects.employee_management_system.service.EmployeeService;
import com.lakiprojects.employee_management_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", employeeDTO), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/delete/{employeeId}")
    public  ResponseEntity<StandardResponse> deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",employeeId),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-all")
    public ResponseEntity<StandardResponse> viewAllEmployees(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Customers viewed successfully",allEmployees),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(params = "id",path = "/search")
    public ResponseEntity<StandardResponse> searchEmployee(@RequestParam(value = "id") int employeeId){
        EmployeeDTO employeeDTO = employeeService.searchEmployee(employeeId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",employeeDTO),HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping(path = "/update")
    public  ResponseEntity<StandardResponse> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmployee(employeeDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated",employeeDTO),HttpStatus.OK);
        return responseEntity;

    }

}
