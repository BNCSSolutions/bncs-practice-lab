package com.springjpa01.emp1_db.service;

import com.springjpa01.emp1_db.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Optional<Employee> updateEmployee(int id, double salary, String designation);
    boolean deleteEmployee(int id);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int id);
}
