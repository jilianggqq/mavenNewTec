package edu.gqq.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gqq.common.G;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example: Given num = 16, return true.
 * 
 * Given num = 5, return false.
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * @author gqq
 *
 */
public class PowerofFour {

	@Test
	public void testStringNotConflict() {
//		String a = "abc";
//		String b = "cds";
//		boolean r = !a.chars().anyMatch(x -> b.chars().anyMatch(y -> y == x));
		assertFalse(notConflict("abc", "cda"));
		assertTrue(notConflict("abc", "zyx"));
	}

	public boolean notConflict(String a1, String a2) {
		return !a1.chars().anyMatch(x -> a2.chars().anyMatch(y -> y == x));
	}

	@Test
	public void testIsPowerofFour() {
		assertTrue(isPowerOfFour(16));
		assertFalse(isPowerOfFour(8));
	}

	public boolean isPowerOfFour(int num) {
		return Integer.toBinaryString(num).substring(0, 1).equals("1") && Integer.toBinaryString(num).substring(1).length() % 2 == 0
				&& Integer.toBinaryString(num).substring(1).chars().allMatch(x -> x == 48);
	}

	@Test
	public void testToBinaryStr() {
		int num = 4;
		assertEquals(Integer.toBinaryString(8), "1000");
	}

	@Test
	public void testLoopString() {
		String bs = Integer.toBinaryString(16);
		bs.chars().forEach(x -> G.println(x));
		assertEquals(bs.substring(0, 1), "1");
		int num = 16;
		assertTrue(Integer.toBinaryString(num).substring(0, 1).equals("1"));
		G.println(Integer.toBinaryString(num).substring(1));
		assertTrue(Integer.toBinaryString(num).substring(1).length() % 2 == 0);
		assertTrue(Integer.toBinaryString(num).substring(1).chars().allMatch(x -> x == 48));
	}
}
