package edu.gqq.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ArrayListSetTest {
	@Test
	public void testArr() throws Exception {
		List<Integer> arr1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
		List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(arr1);
		set.add(arr2);
		System.out.println(set.size());
	}
	
	@Test
	public void testSet() throws Exception {
		HashMap<String, String> m1 = new HashMap<String, String>();
		HashMap<String, String> m2 = new HashMap<String, String>();
		m1.put("aa", "aa1");
		m1.put("bb", "bb2");
		m2.put("bb", "bb1");
		m2.put("aa", "aa1");
		Set<HashMap<String, String>> set = new HashSet<>();
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
	}
}
