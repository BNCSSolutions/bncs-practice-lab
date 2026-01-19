package com.bncs.empmanagement.service;

import java.util.List;
import java.util.Optional;

import com.bncs.empmanagement.model.Employee2;


public interface EmployeeService {
	

	    boolean addEmp(Employee2 employee);

	    boolean updateEmp(int id, double salary, String designation);

	    boolean deleteEmp(int id);

	    List<Employee2> getAllEmp();

	    Optional<Employee2> searchEmpById(int id);

	}



