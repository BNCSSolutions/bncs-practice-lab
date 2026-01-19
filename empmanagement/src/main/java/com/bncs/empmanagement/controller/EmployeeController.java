package com.bncs.empmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bncs.empmanagement.model.Employee2;
import com.bncs.empmanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/insertdata")
	public Employee2 insertemp(@RequestBody Employee2 employee) {
		return service.insertdata(employee);
	}
	@GetMapping("/getallemp")
	public List<Employee2> getAllEmp(){
		return service.getallempInfo();
	}
	
	@GetMapping("/getemp/{id}")
	public Employee2 getById(@PathVariable int id) {
		return service.getbyId(id);
	}
	
	@PutMapping("update/{id}")
	public Employee2 updateEmpInfo(@PathVariable int id ,@RequestBody Employee2 employee) {
		return service.updatedata(id, employee);
		
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteemp(@PathVariable("id")  int id) {
		service.deleteEmp(id);
		return " Employee " + id + " deleted successfully"; 
		
	}

}
