package edu.gqq.java8.lambda;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionTest {

	public static void main(String[] args) {
		List<PersonTest> persons = Arrays.asList(new PersonTest("Max", 18), new PersonTest("Peter", 23), new PersonTest("Pzter", 23), new PersonTest("Pamela", 23),
				new PersonTest("David", 12));
		Map<Integer, List<PersonTest>> collect = persons.stream().collect(Collectors.groupingBy(x -> x.age));
		collect.forEach((x, v) -> {
			out.println(x);
			v.sort((p1, p2) -> {
				return p1.name.compareTo(p2.name);
			});
			v.forEach(p -> out.print(p.name + " "));

			out.println();
			out.println();
		});
	}
}

class PersonTest {
	String name;
	int age;

	PersonTest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}
