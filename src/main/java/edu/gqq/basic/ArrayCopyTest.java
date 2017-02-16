package edu.gqq.basic;

public class ArrayCopyTest {

	public static void main(String[] args) {

		int arr1[] = { 0, 1, 2, 3, 4, 5 };
		// java.lang.ArrayIndexOutOfBoundsException
		int arr2[] = { 5, 10, 20, 30, 40, 50 };

		// copies an array from the specified source array

		System.arraycopy(arr1, 0, arr2, 2, 1);
		for (int a : arr2) {
			System.out.println(a);
		}
	}
}
