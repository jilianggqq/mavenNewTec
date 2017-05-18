package edu.gqq.basic;

public class MultipleInterfacesTest implements IFirstInterface, ISecondInterface {
	// int i = 300;
	public static void main(String[] args) {
		MultipleInterfacesTest m = new MultipleInterfacesTest();

		// first interface and second interface both have i, compile error.
		// System.out.println(m.i);
	}
}
