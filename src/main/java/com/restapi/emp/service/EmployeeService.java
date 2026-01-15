package com.restapi.emp.service;

import com.restapi.emp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    boolean addEmployee(Employee employee);

    boolean updateEmployee(int id, double salary, String designation);

    boolean deleteEmployee(int id);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(int id);
}
