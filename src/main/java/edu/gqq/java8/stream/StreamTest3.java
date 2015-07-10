package edu.gqq.java8.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

import edu.gqq.generic.Out;
import static java.lang.System.out;

/**
 * this is about reuse of stream.
 * 
 * @author peter
 *
 */
public class StreamTest3 {
	public static void main(String[] args) {
		// 1. the second use of stream will cause an exception.
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

		stream.anyMatch(s -> true); // ok
		// stream.noneMatch(s -> true); // exception

		// 2. we could create a stream supplier to construct a new stream with all intermediate operations already set up
		Supplier<Stream<String>> sStr = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("b"));
		out.println(sStr.get().anyMatch(x -> x.startsWith("b")));
		out.println(sStr.get().allMatch(x -> x.startsWith("b")));
		out.println(sStr.get().count());
		out.println(sStr.get().isParallel());
	}
}
