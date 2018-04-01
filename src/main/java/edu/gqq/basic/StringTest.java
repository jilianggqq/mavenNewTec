package edu.gqq.basic;

public class StringTest {

	public static void main(String[] args) {
		// "abcd" is in the string pool and its reference is pointed to aa
		String aa = "abcd";
		// look from string pool and get the reference. so bb == aa.
		String bb = "abcd";
		System.out.println(aa == bb); // true;
		String cc = new String("abcd");

		System.out.println(aa == cc); // false;

		// intern() method to store the String object into String pool or return the reference
		// if there is already a String with equal value present in the pool.
		System.out.println(aa == cc.intern()); // true;

		// 2.The method foo(String) is ambiguous for the type StringTest
		// foo(null);

		// As explained in the article you linked to, the only difference between those two methods is the return type.
		// One returns a String and the other returns a CharSequence.

		// The thing to understand is that CharSequence is an interface,
		// and String is a class which implements CharSequence.
		String string = "Hello";
		CharSequence subSequence = string.subSequence(0, 5);
		System.out.println(subSequence.subSequence(1, 4));
		subSequence = subSequence.subSequence(1, 4);
		System.out.println(subSequence);
	}

	public static void foo(String s) {
		System.out.println("String");
	}

	public static void foo(StringBuffer sb) {
		System.out.println("StringBuffer");
	}
}
