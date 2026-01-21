package com.bncs.empmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bncs.empmanagement.model.Employee2;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee2, Integer> {
	Optional<Employee2> findById(int id);

	

}
