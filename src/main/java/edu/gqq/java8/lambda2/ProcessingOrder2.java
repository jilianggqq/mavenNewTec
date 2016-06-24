package edu.gqq.java8.lambda2;

import java.util.stream.Stream;

import org.junit.Test;

import edu.gqq.common.G;

public class ProcessingOrder2 {

	/**
	 * First, the sort operation is executed on the entire input collection. <br>
	 * In other words sorted is executed horizontally. <br>
	 * So in this case sorted is called eight times for multiple combinations on every element in the input collection.
	 */
	public static void moreTime() {
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
	}

	public static void lessTime() {
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
	
	@Test
	public void doTest() {
		moreTime();
		G.println();
		lessTime();
	}
}
