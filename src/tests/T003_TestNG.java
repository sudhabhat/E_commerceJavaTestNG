package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T003_TestNG {


/**
 * Simple assert test using TestNg
 */
	@Test
	public void testAdd() {
		String str = "TestNG is working fine";
		assertEquals("TestNG is working fine",str);
	}
}
