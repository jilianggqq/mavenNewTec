package edu.gqq.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.lang.System.out;

/**
 * the usage of collector
 * 
 * @author peter
 *
 */
public class StreamTest4 {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23), new Person("David", 12));
		// 1. search name contains p
		List<Person> pPersons = persons.stream().filter(x -> x.name.contains("P")).collect(Collectors.toList());
		pPersons.forEach(System.out::println);

		// 2. grouping people by age
		Map<Integer, List<Person>> agePersons = persons.stream().collect(Collectors.groupingBy(x -> x.age));
		agePersons.forEach((age, ps) -> {
			out.format("age:%s, persons:%s\n", age, ps);
		});

		// 3.average age
		Double average = persons.stream().collect(Collectors.averagingInt(x -> x.age));
		out.println(average);

		// 4.to map.You can optionally pass a merge function as an additional
		// parameter to bypass the exception
		Map<Integer, String> mPersons = persons.stream().collect(Collectors.toMap(p -> p.age, p -> p.name, (x, y) -> {
			return x + " " + y;
		}));
		mPersons.forEach((i, s) -> {
			out.format("\nage:%s, name:%s", i, s);
		});

		// 5. custom collect is very hard. we must understand a supplier, an
		// accumulator, a combiner and a finisher.
		// we will finish next time.
	}
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}