package com.bncs.Employee1.model;

	import lombok.Data;

	@Data
	public class Employee {
		
		int id;
		String name;
		int age;
		String role;
		double salary;
		
		public Employee() {
			
		}
		
		public Employee(int id, String name, int age,String role, double salary) {
			this.id=id;
			this.name=name;
			this.age=age;
			this.role=role;
			this.salary=salary;
			
		}

		public int getId() {
			return id;
		}

		
		

	}


