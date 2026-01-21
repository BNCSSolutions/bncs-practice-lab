package com.sbjpavalid02.emp02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbjpavalid02.emp02.model.Employee;
import com.sbjpavalid02.emp02.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repo;

	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Employee addEmployee(Employee employee) {

		if (repo.existsByEmployeeIdOrEmail(employee.getEmployeeId(), employee.getEmail())) {
			throw new RuntimeException("Employee already exists");
		}

		return repo.save(employee);
	}

	@Override
	public Employee updateEmployee(int id, String designation, double salary, String email) {

		Employee emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

		emp.setDesignation(designation);
		emp.setSalary(salary);
		emp.setEmail(email);

		return repo.save(emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		if (!repo.existsById(id)) {
			throw new RuntimeException("Employee not found");
		}
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}
}
