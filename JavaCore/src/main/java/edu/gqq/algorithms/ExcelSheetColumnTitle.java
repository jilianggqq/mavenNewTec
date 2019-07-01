package edu.gqq.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n >= 1) {
			int s = n - 1;
			sb.append(convertToString(s % 26));
			n = s / 26;
		}
		return sb.reverse().toString();
	}

	public String convertToString(int n) {
		return (char) (n + 65) + "";
	}

	@Test
	public void testResult() throws Exception {
		assertEquals("A", convertToTitle(1));
		assertEquals("Z", convertToTitle(26));
		assertEquals("AA", convertToTitle(27));
		assertEquals("AB", convertToTitle(28));
		assertEquals("AAA", convertToTitle(703));
	}
	
	@Test
	public void testAscii() throws Exception {
		assertEquals('A', (char) 65);
		assertEquals((Integer)3, Integer.valueOf('3'+""));
	}
}
