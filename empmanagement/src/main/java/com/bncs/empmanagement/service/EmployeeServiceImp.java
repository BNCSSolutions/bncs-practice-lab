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

	    if (employee == null ||
	        employee.getName() == null || employee.getName().isBlank() ||
	        employee.getDesignation() == null || employee.getDesignation().isBlank() ||
	        employee.getSalary() < 0) {
	        return false;
	    }

	    repository.save(employee); 
	    return true;
	}


//	    Update Employee
	@Override
	public boolean updateEmp(int id, Employee2 updatedEmployee) {

	    // Validate input
	    if (updatedEmployee.getSalary() < 0 ||
	        updatedEmployee.getDesignation() == null || updatedEmployee.getDesignation().isBlank()) {
	        return false;
	    }

	    // Find employee by id and update all fields
	    return repository.findById(id)
	        .map(emp -> {
	            emp.setName(updatedEmployee.getName());
	            emp.setAge(updatedEmployee.getAge());
	            emp.setDesignation(updatedEmployee.getDesignation());
	            emp.setDepartment(updatedEmployee.getDepartment());
	            emp.setEmail(updatedEmployee.getEmail());
	            emp.setGender(updatedEmployee.getGender());
	            emp.setSalary(updatedEmployee.getSalary());

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
