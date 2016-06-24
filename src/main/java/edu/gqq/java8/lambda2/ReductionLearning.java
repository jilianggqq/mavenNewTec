package edu.gqq.java8.lambda2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import edu.gqq.common.G;
import edu.gqq.generic.Out;
import static org.junit.Assert.*;

public class ReductionLearning {

	/**
	 * The first one reduces a stream of elements to exactly one element of the stream.
	 */
	@Test
	public void testReduce1() {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));
		persons.stream().reduce((p1, p2) -> p1.age > p2.age ? p1 : p2).ifPresent(System.out::println);
		int addAge = persons.stream().mapToInt(x -> x.age).reduce(0, (a1, a2) -> a1 + a2);
		assertEquals(77, (int) addAge);

	}

	/**
	 * The second reduce method accepts both an identity value and a BinaryOperator accumulator. <br>
	 * This method can be utilized to construct a new Person with the aggregated names and ages from all other persons in the stream:
	 */
	@Test
	public void testReduce2() {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));

		Person result =
			    persons
			        .stream()
			        .reduce(new Person("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

			System.out.format("name=%s; age=%s", result.name, result.age);
			// name=MaxPeterPamelaDavid; age=76
	}

	/**
	 * The third reduce method accepts three parameters:<br>
	 * an identity value, a BiFunction accumulator and a combiner function of type BinaryOperator.
	 */
	@Test
	public void testReduce3() {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));
		Integer addAge = persons.stream().reduce(0, (p, v) -> {
			System.out.format("accumulator: sum=%s; person=%s\n", p, p);
			return p += v.age;
		} , (x, y) -> {
			System.out.format("combiner: sum1=%s; sum2=%s\n", x, y);
			return x + y;
		});

		IntSummaryStatistics addAge2 = persons.stream().collect(Collectors.summarizingInt(x -> x.age));
		// G.println(addAge);
		// how to get a sum
		int addAge3 = persons.stream().mapToInt(p -> p.age).sum();

		assertEquals(77, (int) addAge);
		assertEquals(77, (int) addAge3);
		assertEquals(77, addAge2.getSum());

	}
}
