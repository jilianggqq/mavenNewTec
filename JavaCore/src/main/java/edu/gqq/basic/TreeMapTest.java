package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {
	@Test
	public void testName() throws Exception {
		// creating tree map
		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();

		// populating tree map
		treemap.put(2, "two");
		treemap.put(1, "one");
		treemap.put(3, "three");
		treemap.put(6, "six");
		treemap.put(5, "five");

		// putting values in set
		for (Map.Entry<Integer, String> entry : treemap.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		
		Entry<Integer, String> ceilingEntry0 = treemap.ceilingEntry(1);
		Entry<Integer, String> ceilingEntry1 = treemap.ceilingEntry(4);
		Entry<Integer, String> ceilingEntry2 = treemap.ceilingEntry(5);
		Entry<Integer, String> ceilingEntry3 = treemap.ceilingEntry(7);
		Entry<Integer, String> floorEntry0 = treemap.floorEntry(4);
		assertEquals(ceilingEntry0.getKey().intValue(), 1);
		assertEquals(ceilingEntry1.getKey().intValue(), 5);
		assertEquals(ceilingEntry2.getKey().intValue(), 5);
		assertNull(ceilingEntry3);
		assertEquals(floorEntry0.getKey().intValue(), 3);
	}
	
}
