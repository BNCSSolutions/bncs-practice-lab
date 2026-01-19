package com.restapi.emp.controller;

import com.restapi.emp.model.Employee;
import com.restapi.emp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return "Employee added";
    }

    // READ ALL
    @GetMapping("/getEmp")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateEmployee(
            @PathVariable int id,
            @RequestParam double salary,
            @RequestParam String designation) {

        service.updateEmployee(id, salary, designation);
        return "Employee updated";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted";
    }
}
