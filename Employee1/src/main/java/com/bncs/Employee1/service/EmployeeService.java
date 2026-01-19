package com.bncs.Employee1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bncs.Employee1.model.Employee;
import com.bncs.Employee1.repository.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo EmployeeRepo;
	
	public Employee insertEmp(Employee employee) {
		EmployeeRepo.employeeMap.put(employee.getId(),employee);
		return employee;
	}
	
	public Collection<Employee> getAllEmpInfo(){
		return EmployeeRepo.employeeMap.values();
	}
	
	public Employee getByEmpId(int id) {
		return EmployeeRepo.employeeMap.get(id);
		
	}
	
	public Employee updateEmp(int id, Employee employee) {
		EmployeeRepo.employeeMap.put(id, employee);
		return employee;
	}
	
	public String deleteEmp(int id) {
		EmployeeRepo.employeeMap.remove(id);
		return "Deleted Employee Successfully";
	}

}

