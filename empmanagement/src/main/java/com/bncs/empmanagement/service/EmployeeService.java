package com.bncs.empmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bncs.empmanagement.model.Employee2;
import com.bncs.empmanagement.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo emprepo;
	
//  Create
	public Employee2 insertdata( Employee2 employee) {
		return emprepo.save(employee);
	}
//	Read All
	public List<Employee2> getallempInfo(){
		return emprepo.findAll();
	}
//	Read by Id
	public Employee2 getbyId(int id) {
		return emprepo.findById(id).orElse(null);
	}
	
//	update 
	public Employee2 updatedata( int id ,Employee2 emp) {
		emp.setId(id);
		return emprepo.save(emp);
	}
	
//	delete 
	public String deleteEmp(int id) {
		emprepo.deleteById(id);
		return "Deleted Successfully";
	}
}
