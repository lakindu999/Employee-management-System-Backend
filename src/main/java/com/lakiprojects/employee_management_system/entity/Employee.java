package com.lakiprojects.employee_management_system.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_Id",length = 100)
    private int employeeId;

    @Column(name = "Employee_Name",length = 100,nullable = false)
    private String employeeName;

    @Column(name = "Employee_Address",length = 100,nullable = false)
    private String employeeAddress;

    @Column(name = "Employee_Phone",length = 15,nullable = false)
    private int employeePhone;

}
