package edu.gqq.leetcode.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QuickHashSet {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		set.forEach(System.out::println);

		int number = set.stream().findFirst().get();
		
		List<HashSet<Integer>> list = new ArrayList<>();
		list.add(set);
		System.out.println(list.size());
		System.out.println(number);
		set.remove(10);
		set.remove(11);
		set.forEach(System.out::println);
	}
}
