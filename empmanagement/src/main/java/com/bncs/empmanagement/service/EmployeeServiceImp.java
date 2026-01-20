package com.bncs.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bncs.empmanagement.model.Employee2;
import com.bncs.empmanagement.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepo repository;

//	     Constructor Injection
	public EmployeeServiceImp(EmployeeRepo repository) {
		this.repository = repository;
	}

//	    Add Employee
	@Override
	public boolean addEmp(Employee2 employee) {

		if (employee == null || employee.getId() <= 0 || employee.getSalary() < 0 || employee.getName() == null
				|| employee.getName().isBlank() || employee.getDesignation() == null
				|| employee.getDesignation().isBlank()) {
			return false;
		}

		repository.save(employee);
		return true;
	}

//	    Update Employee
	@Override
	public boolean updateEmp(int id, double salary, String designation) {

	    if (salary < 0 || designation == null || designation.isBlank()) {
	        return false;
	    }

	    return repository.findById(id)
	        .map(emp -> {
	            emp.setSalary(salary);
	            emp.setDesignation(designation);
	            repository.save(emp);
	            return true;
	        })
	        .orElse(false);
	}


//	    Delete Employee By Id
	@Override
	public boolean deleteEmp(int id) {
		repository.deleteById(id);
		return true;
	}

//	     Get all employees
	@Override
	public List<Employee2> getAllEmp() {
		return repository.findAll();
	}

//	     Search Employee by Id 
	@Override
	public Optional<Employee2> searchEmpById(int id) {
		return repository.findById(id);
	}

}
