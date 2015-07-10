package edu.gqq.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.System.out;

public class StreamTest1 {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		// 1. map change Stream<T1> to Stream<T2>
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		// 2. implements interface through Anonymous functions
		myList.stream().map(new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.valueOf(t.substring(1));
			}
		}).forEach(System.out::println);

		// 3.if we meet optional, what should we do?
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println); // a1

		// 4. change a range of int to object.
		IntStream.range(1, 4).mapToObj(x -> x + "a").forEach(out::println);

		// 5.how to change 4.0,5.0,6.0 to 4a, 5a, 6a, maybe this is the
		// excellent way.
		DoubleStream.of(3.0, 4.0, 5.0).mapToInt(x -> (int) x).mapToObj(y -> y + "b").forEach(out::println);

		// 6. reduce the actual number of operations performed on each element,
		// each element moves along the chain vertically
		// in this example, map has only to be executed twice in this case.
		// So instead of mapping
		// all elements of the stream, map will be called as few as possible.
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			out.println("anyMatch: " + s);
			boolean b = s.startsWith("A");
			out.println("result: " + b);
			return b;
		});
	}
}
