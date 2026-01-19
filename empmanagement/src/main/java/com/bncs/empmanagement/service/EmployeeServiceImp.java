package com.bncs.empmanagement.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bncs.empmanagement.model.Employee2;

@Service
public  class EmployeeServiceImp implements EmployeeService {
	
	
	    private Map<Integer, Employee2> empMap = new HashMap<>();

//	    Add Emp
	    @Override
	    public boolean addEmp(Employee2 employee) {

	        if (employee == null ||
	            employee.getId() <= 0 ||
	            employee.getSalary() < 0 ||
	            employee.getName() == null || employee.getName().isBlank() ||
	            employee.getDesignation() == null || employee.getDesignation().isBlank()) {
	            return false;
	        }

//	         Duplicate id validation
	        if (empMap.containsKey(employee.getId())) {
	            return false;
	        }

	        empMap.put(employee.getId(), employee);
	        return true;
	    }

//	    Update Employee
	    @Override
	    public boolean updateEmp(int id, double salary, String designation) {

	        if (salary < 0 || designation == null || designation.isBlank()) {
	            return false;
	        }

	        Employee2 emp = empMap.get(id);
	        if (emp == null) {
	            return false;
	        }

	        emp.setSalary(salary);
	        emp.setDesignation(designation);
	        return true;
	    }

//	    Delete Employee
	    @Override
	    public boolean deleteEmp(int id) {
	        return empMap.remove(id) != null;
	    }

//	     Get all employees
	    @Override
	    public List<Employee2> getAllEmp() {
	        return new ArrayList<>(empMap.values());
	    }

//	     Search by ID 
	    @Override
	    public Optional<Employee2> searchEmpById(int id) {
	        return Optional.ofNullable(empMap.get(id));
	    }

	   
	}


