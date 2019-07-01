package edu.gqq.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {
	@Test
	public void testName() throws Exception {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(2);
		treeSet.add(8);
		treeSet.add(13);
		treeSet.add(4);
		treeSet.add(10);
		// treeSet.forEach(ele->System.out.println(ele));
		Integer floorthan9 = treeSet.floor(9);
		Integer ceilthan10 = treeSet.ceiling(10);
		Integer floorthan1 = treeSet.floor(1);
		assertEquals(8, floorthan9.intValue());
		assertEquals(10, ceilthan10.intValue());
		assertNull(floorthan1);

	}
}
