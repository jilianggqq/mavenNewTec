package edu.gqq.reflect.two;

import edu.gqq.reflect.Person;

public class PersonTest {
	public static void main(String[] args) {

		Person p;
		try {
			p = new Person();
			p.nameString = "ttt";
		} catch (Exception e) {
			System.out.println("main fault");
			e.printStackTrace();
		}
	}
}
