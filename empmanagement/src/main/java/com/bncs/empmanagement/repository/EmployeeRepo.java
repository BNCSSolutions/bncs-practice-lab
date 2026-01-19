package com.bncs.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bncs.empmanagement.model.Employee2;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee2, Integer> {

	

}
