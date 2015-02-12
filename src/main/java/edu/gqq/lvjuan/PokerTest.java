package edu.gqq.lvjuan;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetrank() {
		// fail("Not yet implemented");
		int[] outputs = { 0, 0, 0, 0 };
		int[] des = { 14, 13, 12, 11 };
		int rank = Poker.getRank(outputs, "Q,J,K,A");
		// System.out.println(rank);

		assertArrayEquals(des, outputs);
		assertEquals(4, rank);
	}

	@Test
	public void testGetrankValue() {
		Integer[] vals = { 3, 5, 3, 3 };
		int rank = Poker.getRankValue(vals);

		// assertArrayEquals(des, outputs);
		assertEquals(3, rank);
	}

}
