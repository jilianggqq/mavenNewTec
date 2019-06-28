package edu.gqq.java8.lambda;

import java.util.ArrayList;
import java.util.List;

import edu.gqq.reflect.Person;

public class TestLambda3 {
	public static void main(String[] args) {
		List<edu.gqq.reflect.Person> people = new ArrayList<>();
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("peter1");
		people.add(p1);

		Person p2 = new Person();
		p2.setId(2);
		p2.setName("peter2");
		people.add(p2);

		people.forEach(x -> x.accept(x));
	}
}
