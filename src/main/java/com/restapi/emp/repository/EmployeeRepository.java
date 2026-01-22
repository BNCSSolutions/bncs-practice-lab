package com.restapi.emp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByEmployeeIdOrEmail(String employeeId, String email);
}