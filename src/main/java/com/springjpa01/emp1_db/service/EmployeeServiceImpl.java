package com.springjpa01.emp1_db.service;

import com.springjpa01.emp1_db.model.Employee;
import com.springjpa01.emp1_db.repository.EmployeeRepository;
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
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(int id, double salary, String designation) {
        Optional<Employee> empOpt = repository.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setSalary(salary);
            emp.setDesignation(designation);
            repository.save(emp);
            return Optional.of(emp);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
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
