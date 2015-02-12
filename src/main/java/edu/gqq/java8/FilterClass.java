package edu.gqq.java8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FilterClass {

	public static void main(String[] args) {
		List<String> strs = Arrays.asList("aaa", "bab", "cca", "ddd");

		strs.stream().filter(x -> x.contains("a")).forEach(s -> System.out.println(s));
		System.out.println();
		strs.parallelStream().filter(x -> x.contains("a")).forEach(s -> System.out.println(s));
	}
}
