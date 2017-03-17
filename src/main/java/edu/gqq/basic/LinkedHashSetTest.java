package edu.gqq.basic;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet maintains a linked list of the entries in the set, in the order
 * in which they were inserted. This allows insertion-order iteration over the
 * set.
 * 
 * @author gqq
 *
 */
public class LinkedHashSetTest {
	public static void main(String args[]) {
		// create a hash set
		LinkedHashSet<String> hs = new LinkedHashSet<>();

		// add elements to the hash set
		hs.add("B");
		hs.add("A");
		hs.add("D");
		hs.add("E");
		hs.add("A");
		hs.add("A");
		hs.add("C");
		hs.add("F");
//		System.out.println(hs);
		Iterator<String> iterator = hs.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
