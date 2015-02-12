package edu.gqq.reflect;


public class Person {

	public String nameString;
	public Person() throws Exception {
		if (!this.getClass().getPackage().getName().equals("edu.gqq.reflect"))
			throw new Exception();
	}

	public void doReflect() {

	}

	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.nameString = "ttt";
		System.out.print(person.nameString);
	}
}
