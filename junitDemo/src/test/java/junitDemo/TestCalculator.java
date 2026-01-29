package junitDemo;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.bncs.Calculator;

class TestCalculator {
	
	private Calculator c;

	@BeforeEach
	void setup() {
		System.out.println("BeforeEach ");
		c= new Calculator();
	}
	
	@BeforeAll
	static void setupThis() {
		System.out.println("BeforeAll Executed");
		
	}
	@Tag("first_Class")
	@Test
	void method1() {
		System.out.println("Method 1 Executed");
		
		Assertions.assertEquals(6,c.add(3, 3));
		
	}
	
	@Test
	void method2() {
		System.out.println("Method 2 Executed");
	}
	

	@AfterAll
	static void setupThis1() {
		System.out.println("AfterAll Executed");
		
	}
	@Disabled
	@DisplayName("Important Method")
	@Test
	void method3() {
		System.out.println("Method 3 Executed");
	}
	@Test
	void method4() {
		System.out.println("Method 4 Executed");
		
	}
	@AfterEach
	void setup1() {
		System.out.println("AfterEach ");
		
		System.out.println("***************************");

	}
	
	@Test
	void method5() {
		String a="xyz";
		String b="xyz";
		
		assertSame(b, a);
		System.out.println("same");
	}
	@Test
	void method6() {
		
		
		assertTrue(30>20);
		System.out.println("true is printed");
	}
	
	
	 @Test
	    void method7() {
		assertEquals(6,c.divide(60, 10));
		System.out.println("method 7 executed");

	    }

	
}
