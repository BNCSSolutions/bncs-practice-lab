package com.bncs.Employee1.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bncs.Employee1.model.Employee;

@Repository
public class EmployeeRepo {
	public static Map<Integer ,Employee> employeeMap= new HashMap<>();
	}


