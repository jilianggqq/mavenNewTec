package edu.gqq.basic;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class OverrideHashCodeTest {
	@Test
	public void testOverrideHashCode() {
		OverrideHashCode ohc = new OverrideHashCode("s1");
		OverrideHashCode ohc2 = new OverrideHashCode("s2");

		HashSet<OverrideHashCode> set = new HashSet<>();
		set.add(ohc);
		set.add(ohc2);
		assertEquals(1, set.size());
		// System.out.println(set);
		assertEquals(ohc, ohc2);

		OverrideHashCode aa = new OverrideHashCode("cab");
		OverrideHashCode bb = new OverrideHashCode("abc");

		set.clear();
		set.add(aa);
		set.add(bb);
		assertEquals(1, set.size());
	}
}
