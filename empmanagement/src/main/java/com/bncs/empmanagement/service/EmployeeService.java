package com.bncs.empmanagement.service;

import java.util.List;
import java.util.Optional;

import com.bncs.empmanagement.model.Employee2;


public interface EmployeeService {
	

	  public boolean addEmp(Employee2 employee);

	   public boolean updateEmp(int id, Employee2 employee);

	   public boolean deleteEmp(int id);

	    public List<Employee2> getAllEmp();

	    public Optional<Employee2> searchEmpById(int id);

	}



