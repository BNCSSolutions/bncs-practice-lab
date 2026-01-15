package com.restapi.emp.service;

import com.restapi.emp.model.Employee;
import com.restapi.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addEmployee(Employee employee) {

        if (employee.getId() <= 0 ||
            employee.getSalary() < 0 ||
            employee.getName() == null || employee.getName().isBlank() ||
            employee.getDesignation() == null || employee.getDesignation().isBlank()) {
            return false;
        }

        if (repository.existsById(employee.getId())) {
            return false;
        }

        repository.save(employee);
        return true;
    }

    @Override
    public boolean updateEmployee(int id, double salary, String designation) {

        if (salary < 0 || designation == null || designation.isBlank()) {
            return false;
        }

        Optional<Employee> empOpt = repository.findById(id);
        if (empOpt.isEmpty()) {
            return false;
        }

        Employee emp = empOpt.get();
        emp.setSalary(salary);
        emp.setDesignation(designation);

        repository.save(emp);
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }
}

