package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.WeakHashMap;

import org.junit.Test;

import edu.gqq.common.G;

/**
 * common bit manipulation.
 * 
 * such as xor, shift left, shift right, & and ||
 * 
 * @author gqq
 *
 */
public class BitManipulationTest {
	@Test
	public void testOperations() throws Exception {
		// 1. set bit
		int a = 0;
		// set 3st bit to 1. a will become 4
		a |= 1 << 2;
		assertEquals(4, a);
		// set 2nd bt to 1
		a |= 1 << 1;
		assertEquals(6, a);
		// 2. clear bit
		// set the 3rd bit to 0, a become 10, that is 2.
		a &= ~(1 << 2);
		assertEquals(2, a);
		// clear bit in pos 5, it is still 2.
		a &= ~(1 << 5);
		assertEquals(2, a);
		// 3. test bit.
		// test bit in pos2
		assertTrue((a & 1 << 1) > 0);
		assertFalse((a & 1 << 2) > 0);
		// 4.get last bit.
		// assertEquals(8 & -8, 0);
		// assertEquals(17 & -17, 1);

		// 5. we usually use (n & (n - 1)) == 0 to test a number is a power of 2
		assertTrue((32 & 31) == 0);
		assertFalse((33 & 32) == 0);

		// 6. in computer, they use complement. x = ~(x - 1)
		assertEquals(-3, ~3 + 1);
		assertEquals(3, ~(-3) + 1);

		// 7. use >>i & 1 to test bit i
		assertEquals(8 >> 3 & 1, 1);
		assertEquals(8 >> 2 & 1, 0);
		
//		8. extract last bit. a & -a, a & (~(a-1))
		assertEquals(2, 6 & -6);
		assertEquals(2, 10 & -10);
		assertEquals(2, 10 & ~9);
	}

	@Test
	public void testCalculateOne() throws Exception {
		assertEquals(Integer.bitCount(7), 3);

		// manually implement above function
		int x = 7;
		int cnt = 0;
		for (int i = 0; i < 32; i++) {
			cnt += x & 1;
			x >>= 1;
		}
		assertEquals(3, cnt);
	}

	@Test
	public void testBinaryString() throws Exception {
		// G.println(Integer.toBinaryString(-4));
		// G.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
		// G.println(~4);
		// G.println(5 & 4);
		assertEquals(Integer.toBinaryString(-5), "11111111111111111111111111111011");
		assertEquals(Integer.toBinaryString(-4), "11111111111111111111111111111100");
		assertEquals(Integer.toBinaryString(-1), "11111111111111111111111111111111");
		assertEquals(Integer.toBinaryString(Integer.MIN_VALUE + 1), "10000000000000000000000000000001");
		assertEquals(Integer.toBinaryString(Integer.MIN_VALUE), "10000000000000000000000000000000");
		assertEquals(0, 0 ^ 0);
//		ass
	}

	@Test
	public void testShiftLeft() throws Exception {
		assertEquals(1, 1 << 0);
		assertEquals(4, 1 << 2);
		assertEquals(8, 1 << 3);
		// using this method to implement add method.
		assertEquals((1 << 1) | 1, 3);
		int x = (((1 & 1) << 1) | (1 ^ 1)) << 1;
		assertEquals(x | 0, 4);
		// 1.test one bit
		assertEquals(8 & (1 << 2), 0);
	}
}
