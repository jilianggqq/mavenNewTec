package edu.gqq.leetcode.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.primitives.Ints;

public class ConvertArrayToList {

	public static void main(String[] args) {
		Integer[] integerarrs = { 3, 4, 6, 7, 8 };

		// 1. first
		List<Integer> asList = Arrays.asList(3, 4, 6, 7, 8);
		asList.forEach(x -> System.out.println(x));

		// 2. from arr
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(integerarrs));

		// 3. but if it is a int[], you have to use guava
		int[] intArrs = { 3, 5, 7, 8 };
		List<Integer> asList2 = Ints.asList(intArrs);

		// 4. use java8
		List<Integer> ints = new ArrayList<>();
		Arrays.stream(intArrs).forEach(x -> ints.add(x));
	}

	// public static void main(String[] args) {
	//
	// }
}
