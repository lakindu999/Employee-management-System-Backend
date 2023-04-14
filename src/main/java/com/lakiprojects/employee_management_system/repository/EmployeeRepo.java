package com.lakiprojects.employee_management_system.repository;

import com.lakiprojects.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
