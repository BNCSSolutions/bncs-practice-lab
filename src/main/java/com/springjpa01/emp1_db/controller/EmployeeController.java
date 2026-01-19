package com.springjpa01.emp1_db.controller;

import com.springjpa01.emp1_db.model.Employee;
import com.springjpa01.emp1_db.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee); 
    }

    @PutMapping("/updated/{id}")
    public Employee updateEmployee(@PathVariable int id,
                                   @RequestParam double salary,
                                   @RequestParam String designation) {
        return service.updateEmployee(id, salary, designation).orElse(null); 
    }

    @DeleteMapping("/deleted/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id); 
    }

    @GetMapping("/getAllEmp")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees(); 
    }

    @GetMapping("/getById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id).orElse(null); 
    }
}
