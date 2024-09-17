package com.vipul;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MyAssertTest {
	List<String> todos = Arrays.asList("AWS", "Devops", "Azure");
	
	@Test
	void testAsserts() {
		boolean test1 = todos.contains("AWS");
		boolean test2 = todos.contains("GCP");
		
//		assertEquals(true, test1);
		assertTrue(test1);
		assertFalse(test2);
		
		assertArrayEquals(new int[] {1, 2}, new int[] {2, 1});
//		assertNull,assertNotNull
		assertEquals(3, todos.size());
	}
}
