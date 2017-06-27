package edu.gqq.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class FailSafeAndFailFast {
	@Test
	public void testFailFast() throws Exception {
		// Creating an ArrayList of integers

		ArrayList<Integer> list = new ArrayList<Integer>();

		// Adding elements to list

		list.add(1452);

		list.add(6854);

		list.add(8741);

		list.add(6542);

		list.add(3845);

		// Getting an Iterator from list
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer val = (Integer) iterator.next();
			System.out.println(val);
			list.add(3); //This will throw ConcurrentModificationException
		}
	}

	@Test
	public void testFailSafe() throws Exception {
		// Creating a ConcurrentHashMap

		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

		// Adding elements to map

		map.put("ONE", 1);

		map.put("TWO", 2);

		map.put("THREE", 3);

		map.put("FOUR", 4);

		// Getting an Iterator from map

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key + "-->" + map.get(key));
			map.put("Five", 5);
		}
	}
}
