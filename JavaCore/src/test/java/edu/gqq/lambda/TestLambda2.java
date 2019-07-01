package edu.gqq.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import edu.gqq.common.Log4jUtil;
import junit.framework.TestCase;

public class TestLambda2 extends TestCase {
	Logger logger = Log4jUtil.getLogger(TestLambda2.class);

	public void doAction(int x) {
		x += 5;
		System.out.println(x);
	}

	public void testStream() {
		int[] arr = { 333, 21, 345, 545 };
		Arrays.stream(arr).forEach(x->System.out.println(x+5));
		IntStream stream = Arrays.stream(arr);

		stream.forEach(x -> {
			x = x + 5;
			System.out.println(x);
		});

		// stream.forEach(System.out::println);
		// you cannot use stream for two times.
		// stream.forEach(new TestLambda2()::doAction);

		// 3. test filter
		long count = Arrays.stream(arr).filter(x -> x > 340).count();
		logger.debug(count);
		assertEquals(2, count);

		// stream.forEach();
	}
	

	private boolean isToolong(String str) {
		return str.length() >= 4 ? true : false;
	}

	public void testCollectionStream() {
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
		assertFalse(anyMatch);

		boolean anyMatch2 = collectionStr.stream().anyMatch(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				// return false;
				return t.startsWith("s");
			}
			// return s.toString().startsWith("c");
		});
		assertTrue(anyMatch2);

		logger.debug("test too long");
		collectionStr.stream().filter(x -> x.contains("o")).map(x -> "Hello " + x.toUpperCase()).forEach(System.out::println);
		
		collectionStr.stream().filter(x -> x.contains("o")).map(x -> {
			StringInfo si = new StringInfo();
			si.length = x.length();
			si.name = x;
			return si;
		}).forEach(logger::debug);
		collectionStr.stream().filter(x -> isToolong(x)).forEach(x -> logger.debug("too long is " + x));
		collectionStr.stream().filter(x -> isToolong(x)).forEach(logger::debug);
		
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

class StringInfo{
	public int length;
	public String name;
	@Override
	public String toString() {
		return String.format("Sting %s's length is %d.", name, length);
	}
}
