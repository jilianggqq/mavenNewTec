package edu.gqq.java8.lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static java.lang.System.out;
import org.junit.Test;

public class LazyProgrammingTest {
	public static Optional<Integer> findFirst(List<Integer> numbers) {
		return numbers.stream().filter(x -> x > 3).filter(x -> x % 2 == 0).map(x -> 2 * x).findFirst();
	}

	public static boolean isGreaterThan3(int number) {
		System.out.println("isGreaterThan3 called for " + number);
		return number > 3;
	}

	/**
	 * isEven is like a implement of Predicate.<br>
	 * It is not necessary to implement predicate interface explicitly.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isEven(int number) {
		System.out.println("isEven called for " + number);
		return number % 2 == 0;
	}

	public static int doubleValue(int number) {
		System.out.println("doubleValue called for " + number);
		return number * 2;
	}

	public static Optional<Integer> compute(List<Integer> numbers) {
		return numbers.stream().filter(x -> LazyProgrammingTest.isGreaterThan3(x)).filter(LazyProgrammingTest::isEven).map(LazyProgrammingTest::doubleValue).findFirst();
	}

	@Test
	public void doTest() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 5, 4, 6, 7);
		Optional<Integer> first = findFirst(nums);
		assertTrue(first.isPresent());
		assertEquals(8, (int) first.get());

		String sfirst = first.map(x -> x.toString()).orElse("empty");
		assertEquals("8", sfirst);

		// test compute
		Optional<Integer> result = compute(nums);
		String sresult = result.map(x->x.toString()).orElse("empty");
		assertEquals("8", sresult);
		
	}
}
