package edu.gqq.reflect.deep;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Class for test copy properties
 *
 * @author Peter Guan
 * @date 19/06/2015
 *
 */
public class TestDeepCopy {
	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setAge(15);
		person.setName("rene");
		person.setNumber(100);

		OtherPerson othePerson = new OtherPerson();

		System.out.println("*** Before BeanUtils.copyProperties ***");

		System.out.println("Person");
		System.out.println(person.getAge());
		System.out.println(person.getName());
		System.out.println(person.getNumber());

		System.out.println("othePerson");
		System.out.println(othePerson.getAge());
		System.out.println(othePerson.getName());
		System.out.println(othePerson.getNumber());

		// copy properties from (target, source)
		BeanUtils.copyProperties(othePerson, person);

		System.out.println("\n*** After BeanUtils.copyProperties ***");

		System.out.println("Person");
		System.out.println(person.getAge());
		System.out.println(person.getName());
		System.out.println(person.getNumber());

		System.out.println("othePerson");
		System.out.println(othePerson.getAge());
		System.out.println(othePerson.getName());
		System.out.println(othePerson.getNumber());

	}
}
