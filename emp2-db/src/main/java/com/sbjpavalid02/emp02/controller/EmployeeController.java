package com.sbjpavalid02.emp02.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.sbjpavalid02.emp02.model.Employee;
import com.sbjpavalid02.emp02.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestParam String designation,
            @RequestParam double salary,
            @RequestParam String email) {
        return service.updateEmployee(id, designation, salary, email);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
}
