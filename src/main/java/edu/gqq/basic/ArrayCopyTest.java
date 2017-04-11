package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import edu.gqq.common.G;

public class ArrayCopyTest {

	public static void main(String[] args) {

		int arr1[] = { 0, 1, 2, 3, 4, 5 };
		// java.lang.ArrayIndexOutOfBoundsException
		int arr2[] = { 5, 10, 20, 30, 40, 50 };

		// copies an array from the specified source array

		System.arraycopy(arr1, 0, arr2, 2, 2);
		// for (int a : arr2) {
		// System.out.println(a);
		// }
		G.println(Arrays.toString(arr2));
	}

	@Test
	public void testDeepCopy2dArray() throws Exception {
		int[][] src = { { 2, 3 }, { 4, 5 } };
		int [][] des = deepCopy(src);
		System.out.println(Arrays.deepToString(des));
	}

	private static int[][] deepCopy(int[][] source) {
		if (source == null) {
			return null;
		}
		int[][] des = new int[source.length][];
		for (int i = 0; i < source.length; i++) {
			des[i] = Arrays.copyOf(source[i], source[i].length);
		}
		return des;
	}
}
