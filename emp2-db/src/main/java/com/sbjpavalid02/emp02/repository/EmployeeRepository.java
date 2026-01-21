package com.sbjpavalid02.emp02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbjpavalid02.emp02.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByEmployeeIdOrEmail(String employeeId, String email);
}