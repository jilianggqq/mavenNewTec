package edu.gqq.algorithms;

import java.util.Arrays;

public class Multiply {
	public static int[] multiply(int[] a, int[] b) {
		int m = a.length, n = b.length;
		int[] res = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mult = a[i] * b[j];
				int val = res[i + j + 1];
				res[i + j + 1] = (val + mult) % 10;
				res[i + j] += (val + mult) / 10;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {3, 2};
		int[] b = {9, 9};
		int[] res = multiply(a, b);
		System.out.println(Arrays.toString(res));
	}
}
