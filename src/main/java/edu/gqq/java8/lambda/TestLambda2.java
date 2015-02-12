package edu.gqq.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestLambda2 {

	@Before
	public void setUp() throws Exception {
	}

	public void doAction(int x) {
		x += 5;
		System.out.println(x);
	}

	@Test
	public void testStream() {
		int[] arr = { 333, 21, 345, 545 };
		IntStream stream = Arrays.stream(arr);

		stream.forEach(x -> {
			x = x + 5;
			System.out.println(x);
		});

		// stream.forEach(System.out::println);
		stream.forEach(new TestLambda2()::doAction);
		
//		stream.forEach();
	}

	@Test
	public void streamDirect() {
		// you can create an Stream directly
		Stream.of(1, 2, "asdfas", 4, 5, "adsfasa", 7, 8, 9, 10).forEach(System.out::println);
	}

	private boolean isToolong(String str) {
		return str.length() >= 4 ? true : false;
	}

	@Test
	public void collectionStream() {
		List<String> collectionStr = new ArrayList<>();

		collectionStr.add("uno");

		collectionStr.add("dos");

		collectionStr.add("tres");

		collectionStr.add("cuatro");

		collectionStr.add("cinco");

		collectionStr.add("seis");

		collectionStr.add("siete");

		collectionStr.add("ocho");

		Stream<String> numbersFromCollection = collectionStr.stream();
		numbersFromCollection.filter(x -> x.toString().startsWith("s")).forEach(System.out::println);
		boolean anyMatch = collectionStr.stream().anyMatch(s -> s.toString().startsWith("a"));
		Assert.assertFalse(anyMatch);

		collectionStr.stream().filter(x -> x.contains("o")).map(x -> "Hello " + x.toUpperCase()).forEach(System.out::println);
		collectionStr.stream().filter(x -> isToolong(x)).forEach(System.out::println);

		System.out.println();
		collectionStr.stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return !isToolong(t);
			}
		}).forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}

}
