package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit 5 Assertions Example")
class Assertions {

	@Test
	@DisplayName("assert Examples")
	public void assertTests() {
		String str=null;
		String str2="some value";
		
		String[] a1= {"A","B"};
		String[] a2= {"A","B"};
		
		assertTrue(4>0);
		assertFalse(4<2);
		assertNull(str);
		assertNotNull(str2);
		
		assertSame(str, str);
		assertNotSame(str, str2);
		
		assertEquals(4,4);
		assertNotEquals(10,4);
		
		assertArrayEquals(a1,a2);
		
		assertThrows(RuntimeException.class,()->{
			throw new RuntimeException();
		});
	}
}