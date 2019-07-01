package edu.gqq.basic;

import static org.junit.Assert.*;

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
	public void testIsDeepCopy() throws Exception {
		List<Integer> out = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		out.add(1);
		in.add(2);
		in.add(3);
		// 1. from this example, we can see addAll is a deep copy.
		out.addAll(in);
		in.set(0, 4);
		out.forEach(x -> System.out.print(" " + x));// 1,2,3
		System.out.println();
		in.forEach(x -> System.out.print(" " + x));// 4,3
		System.out.println();

		List<Integer> in2 = new ArrayList<>(in);
		in.set(0, 5);
		// 2. this example shows new ArrayList(list) is a deepcopy method.
		in.forEach(x -> System.out.print(" " + x));// 5,3
		System.out.println();
		in2.forEach(x -> System.out.print(" " + x));// 4,3
		System.out.println();

	}

	@Test
	public void testArr() throws Exception {
		List<Integer> arr1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
		List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(arr1);
		set.add(arr2);
		// System.out.println(set.size());
		// lists with the same value and order are equal.
		assertEquals(1, set.size());
	}

	@Test
	public void testSet() throws Exception {
		HashMap<String, String> m1 = new HashMap<String, String>();
		HashMap<String, String> m2 = new HashMap<String, String>();
		m1.put("aa", "aa1");
		m1.put("bb", "bb1");
		m2.put("bb", "bb1");
		m2.put("aa", "aa1");
		Set<HashMap<String, String>> set = new HashSet<>();
		set.add(m1);
		set.add(m2);
		// System.out.println(set.size());
		// The map has equal key and value, they are equal.
		assertEquals(1, set.size());
	}

	@Test
	public void testName() throws Exception {

	}
}
