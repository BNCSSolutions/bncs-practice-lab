package com.restapi.emp.service;

import java.util.List;

import com.restapi.emp.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, String designation, double salary, String email);
    boolean deleteEmployee(int id);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}