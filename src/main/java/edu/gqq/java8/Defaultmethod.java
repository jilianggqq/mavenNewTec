package edu.gqq.java8;

import edu.gqq.common.G;

interface IPerson {
	// adds a java 8 default method
	default void sayHello() {
		System.out.println("Hello there!");
	}

	void call();
}

interface Interface2 {
	default void default2() {
		G.println("default2");
	}

	String getStr(int n);
}

class Student implements IPerson {

	@Override
	public void call() {
		// TODO Auto-generated method stub

	}
}

public class Defaultmethod {

	public void doCallPerson(IPerson p) {
		// System.out.print(p.c);
		p.call();
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.sayHello();

		// 没有参数的接口方法，使用Lambda表达式
		IPerson p = () -> System.out.print("Hello GuanQiqiang!");
		IPerson p2 = () -> System.out.println("Hello Cooper!");
		p.call();
		p2.call();
		
		// 有参数的接口方法，如何使用Lambda表达式。
		// interface has a default method, and has only on method.
		Interface2 face2 = n -> n + "+5";
		G.println(face2.getStr(8));
		face2.default2();

		// you can use lambda to struct a interface
		// in fact, lambda is a interface instanse, but the interface has been
		// implemented.
		new Defaultmethod().doCallPerson(() -> System.out.println("MY NAME IS PETER"));
	}
}
