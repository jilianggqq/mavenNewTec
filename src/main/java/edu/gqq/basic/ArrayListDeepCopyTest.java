package edu.gqq.basic;

import java.util.ArrayList;

import edu.gqq.common.G;

public class ArrayListDeepCopyTest {
	public static void main(String[] args) {
		ArrayList<Testor> testors = new ArrayList<>();
		testors.add(new Testor(1, 2));
		ArrayList<Testor> testors2 = new ArrayList<>(testors);
		testors2.get(0).a = 3;
		G.println(testors.get(0).a); 

		ArrayList<Testor> testors3 = new ArrayList<>();
		testors3.add(new Testor(testors.get(0).a, testors.get(0).b));
		testors3.get(0).a = 5;
		G.println(testors.get(0).a);
	}
}

class Testor {
	int a, b;

	public Testor(int aa, int bb) {
		a = aa;
		b = bb;
	}
}
