package com.sbjpavalid02.emp02.service;

import java.util.List;

import com.sbjpavalid02.emp02.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, String designation, double salary, String email);
    boolean deleteEmployee(int id);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}