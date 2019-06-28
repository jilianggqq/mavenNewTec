package edu.gqq.java8.stream;

import static java.lang.System.out;

import java.util.stream.Stream;

/**
 * this class is mainly for stream efficiency.
 * @author peter
 *
 */
public class StreamTest2 {
	public static void main(String[] args) {
		// 1. the order of intermediate is very important. we can see examples below.
		// sort: a2; d2
		// sort: b1; a2
		// sort: b1; d2
		// sort: b1; a2
		// sort: b3; b1
		// sort: b3; d2
		// sort: c; b3
		// sort: c; d2
		// filter: a2
		// map: a2
		// forEach: A2
		// filter: b1
		// filter: b3
		// filter: c
		// filter: d2
		// the comparation is 8 times. to reduce compare times, we can put filter to front.
		Stream.of("d2", "a2", "b1", "b3", "c").sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));

		out.println("***********************************************************");
		// 2.if we mover filter first, the comparation times will reduce.
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).sorted((s1, s2) -> {
			System.out.printf("sort: %s; %s\n", s1, s2);
			return s1.compareTo(s2);
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}
}
