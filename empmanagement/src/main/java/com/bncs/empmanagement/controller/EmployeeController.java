package com.bncs.empmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

//	    Constructor Injection
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	     Add Employee
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee2 employee) {
		boolean result = employeeService.addEmp(employee);
		return result ? "Employee added successfully" : "Validation failed";
	}

//	    Get All Employees
	@GetMapping("/all")
	public List<Employee2> getAllEmployees() {
		return employeeService.getAllEmp();
	}

//	    Search Employee by ID
	@GetMapping("/search/{id}")
	public Optional<Employee2> searchEmployeeById(@PathVariable int id) {
		return employeeService.searchEmpById(id);
	}

//	    Update Employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee2 updatedEmployee) {

		boolean result = employeeService.updateEmp(id, updatedEmployee);

		if (result) {
			return ResponseEntity.ok("Employee updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found or invalid data");
		}
	}

//	    Delete Employee
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		boolean result = employeeService.deleteEmp(id);
		return result ? "Employee deleted successfully" : "Employee not found";
	}

}
