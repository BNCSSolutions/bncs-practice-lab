package com.bncs.empmanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee2 {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @NotBlank(message = "Name is required")
	    private String name;

	    @NotNull(message = "Age is required")
	    @Min(value = 18, message = "Age must be >= 18")
	    private Integer age;

	    @NotBlank(message = "Designation is required")
	    private String designation;

	    @NotBlank(message = "Department is required")
	    private String department;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    private String email;

	    @NotNull(message = "Gender is required")
	    @Enumerated(EnumType.STRING)
	    private Gender gender;

	    @NotNull(message = "Salary is required")
	    @Min(value = 1, message = "Salary must be positive")
	    private Double salary;

	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	
	
	
	
	
	

}
