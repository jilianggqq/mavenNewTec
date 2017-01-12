package edu.gqq.leetcode.basic;

import java.awt.MenuComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LoopMap {
	public static void main(String[] args) {

		// initial a Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Jan");
		map.put("2", "Feb");
		map.put("3", "Mar");
		map.put("4", "Apr");
		map.put("5", "May");
		map.put("6", "Jun");

		// Map -> Set -> Iterator -> Map.Entry -> troublesome, not recommend!
		System.out.println("\nExample 1...");
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
			System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
		}

		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 2...");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

		// weired, but works anyway, not recommend!
		System.out.println("\nExample 3...");
		for (Object key : map.keySet()) {
			System.out.println("Key : " + key.toString() + " Value : " + map.get(key));
		}

		// Java 8 only, forEach and Lambda. recommend!
		System.out.println("\nExample 4...");
		map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 5...");
		HashSet<String> keys = new HashSet<>();
		int number = 0;
		while (map.size() > 0 && number++ < 2) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				// System.out.println("Key : " + entry.getKey() + " Value : " +
				// entry.getValue());
				if (entry.getKey().equals("3") || entry.getKey().equals("4")) {
					keys.add(entry.getKey());
				}
				if (entry.getKey().equals("1") || entry.getKey().equals("5")) {
					entry.setValue("New");
				}
			}
			keys.forEach(key -> map.remove(key));
			map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
		}
	}

}
