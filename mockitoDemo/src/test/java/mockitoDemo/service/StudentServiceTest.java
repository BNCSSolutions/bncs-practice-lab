package mockitoDemo.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
public class StudentServiceTest {

	@Mock
	StudentService service;

	@InjectMocks
	Student student;

	@Test
	void getAvgMarksTest() {
	when(service.getTotalMarks()).thenReturn(500);
	when(service.getTotalStudents()).thenReturn(10);
	
	Assertions.assertEquals(50,student.getAvgMarks());

	}
}
