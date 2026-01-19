package com.bncs.Employee1.model;

	import lombok.Data;

	@Data
	public class Employee {
		
		private int id;
		private String name;
		private int age;
		private String role;
		private double salary;
		
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


