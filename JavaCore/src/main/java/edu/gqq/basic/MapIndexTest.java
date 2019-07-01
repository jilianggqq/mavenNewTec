package edu.gqq.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapIndexTest {
	public static void main(String[] args) {
		int[] inputIndexs = { 0, 1, 2, 3, 4, 5 };
		int n = inputIndexs.length;
		for (int index : inputIndexs) {
			System.out.print((1 + 2 * index) % (n | 1) + "  ");
		}
		System.out.println();
	}

	@Test
	public void testOr() throws Exception {
		System.out.println(32 | 1);
		System.out.println(1 | 1);
		System.out.println(2 | 1);
	}
}
