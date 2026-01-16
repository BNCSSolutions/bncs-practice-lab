package com.bncs.Employee.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bncs.Employee.model.Employee;
import com.bncs.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employeesdata")
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	@PostMapping("/insertEmp")
	public Employee insertEmployee(@RequestBody Employee employee) {
		return empservice.insertEmp(employee);
	}
	
	@GetMapping("/getAllData")
	public Collection<Employee> getAllEmpInfo(){
		return empservice.getAllEmpInfo();
	}
	
	@GetMapping("/getbyid/{id}")
	public Employee getempById(@PathVariable int id) {
		return empservice.getByEmpId(id);
	}
	@PutMapping("/git clone /{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee employee) {
		return empservice.updateEmp(id, employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		return empservice.deleteEmp(id);
	}

}
