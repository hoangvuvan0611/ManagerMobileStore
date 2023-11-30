package com.example.managermobilestore.services;

import com.example.managermobilestore.domain.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long employeeId);
    Employee saveNewEmployee(Employee employee);
}
