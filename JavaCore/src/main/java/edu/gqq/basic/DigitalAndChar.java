package edu.gqq.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitalAndChar {
	@Test
	public void testDigitalToChar() throws Exception {
		int a = 40;
		char b = (char) a;
		assertEquals(40, b);
		assertEquals('(', b);

		a = 7;
		b = (char) a;
		assertEquals(7, b);
		assertNotEquals('7', b);
	}

	@Test
	public void testDigitalToChar2() throws Exception {
		int a = 8;
		char forDigita = Character.forDigit(a, 10);
		assertEquals('8', forDigita);

		// if value of int is larger than 9, using this method will return 0;
		int b = 18;
		char forDigitb = Character.forDigit(b, 10);
		assertEquals(0, forDigitb);
	}
}
