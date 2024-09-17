package com.vipul;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Running tests on calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
	
	int x=0;
	Calculator c;
	boolean condition;
	
	@BeforeAll
	//static void first() {
	void first() {
		c = new Calculator();
		condition = true;
		System.out.println("********Before All********");
	}
	
	@AfterAll
	//static void last() {
	void last() {
		System.out.println("********After All*********");
	}
	
	@BeforeEach
	void init() {
		System.out.println("Before each test case");
	}
	
	@AfterEach
	void done() {
		System.out.println("After each test case");
	}

	@Test
	@DisplayName("Just for testing")
	@Tag("Demo")
	void test() {
//		System.out.println("Just for demo");
		x=10;
		System.out.println("From test() " + x);
	}
	
	@Test
	@DisplayName("Testing add method")
	@Tag("Math")
	void testAdd() {
		int actual = c.add(15, 30);
		int expected = 45;
		assertEquals(expected, actual, "The addition method is not implemented correctly");
		x=20;
		System.out.println("From testAdd() " + x);
	}
	
	@Test
	@Tag("Math")
	void testSub() {
		assumeTrue(condition);
		int z = 30, y = 45;
		assertEquals(-15, c.sub(z, y), ()-> "The substraction method with argument of "+z+" & "+y+" is not implemented correctly");
		x=20;
		System.out.println("From testSub() " + x);
	}
	
	@Test
	@Tag("Math")
	void testMul() {
		assertAll(
					() -> assertEquals(10, c.mul(2,5)),
					() -> assertEquals(20, c.mul(4,5)),
					() -> assertEquals(30, c.mul(5,6)),
					() -> assertEquals(40, c.mul(8,5)),
					() -> assertEquals(50, c.mul(25,2))
				);
	}
	
	@Test
	@Tag("Math")
	void testDiv() {
		assertThrows(ArithmeticException.class, ()->c.div(5, 0));
		System.out.println("From testDiv() " + x);
	}
	
	@Test
	@Disabled
	@Tag("Demo")
	void testDemo() {
		System.out.println("Simply added to see the demo");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@EnabledOnJre(JRE.JAVA_21)
	@Tag("OS")
	void testWindows() {
		System.out.println("Fow Windows OS only");
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@Tag("OS")
	void testLinux() {
		System.out.println("Fow Linux OS only");
	}

}
