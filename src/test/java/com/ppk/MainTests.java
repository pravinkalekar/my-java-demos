package com.ppk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTests {
	
	@Test
	public void testMaskEmailAddress() {
		
		String input = "Sample message containing an email address USER@domain.com where in the email address user@domain.com should get masked";
		String expected = "Sample message containing an email address XXXXXXXXXXXXXXX where in the email address XXXXXXXXXXXXXXX should get masked";
		
		String actual = Main.maskEmailAddress(input);
		
		assertEquals(expected, actual);
	}

}
