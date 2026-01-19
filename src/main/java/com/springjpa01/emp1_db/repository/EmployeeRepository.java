package com.springjpa01.emp1_db.repository;

import com.springjpa01.emp1_db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Spring Data JPA provides all CRUD methods automatically
}
