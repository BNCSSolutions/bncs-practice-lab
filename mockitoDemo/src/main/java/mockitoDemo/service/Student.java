package mockitoDemo.service;

public class Student {
	
	StudentService service;
	
	public Student(StudentService service) {
		this.service=service;
		
		
	}
	
	
	int getAvgMarks() {
		
		return service.getTotalMarks()/service.getTotalStudents();
	}

}
