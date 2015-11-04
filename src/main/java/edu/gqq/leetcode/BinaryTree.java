package edu.gqq.leetcode;

import static java.lang.System.out;

import java.util.ArrayList;

public class BinaryTree {
	public static void main(String[] args) {
		// default is E
		double log = Math.log(Math.E);
		out.println(log);

		double log2 = log2(8);
		out.println(log2);

		int n3 = getHeight(3);
		out.println(n3);

		int n1 = getHeight(1);
		out.println(n1);

		int n6 = getHeight(6);
		out.println(n6);

		int n7 = getHeight(7);
		out.println(n7);
		
		ArrayList a = new ArrayList();
		a.add(3);
		a.remove(0);
		a.add(4);
		out.println(a.size());
//		int a1 = 
//		out.println(a.get(0));
	}

	public static double log2(double d) {
		return Math.log(d) / Math.log(2);
	}

	public static int getHeight(int num) {
		return (int) Math.ceil(log2(num + 1));
	}
}
