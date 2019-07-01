package edu.gqq.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsShuffle/article.html
 * @author gqq
 *
 */
public class ShufflePoker {
	public static void shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Random random = new Random();
			int change = i + random.nextInt(arr.length - i);
			swap(arr, change, i);
		}
	}

	private static void swap(int[] arr, int change, int i) {
		int tmp = arr[change];
		arr[change] = arr[i];
		arr[i] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		
		// it is List<int[]>, but not List<Integer>
		List<int[]> asList = Arrays.asList(arr);
//		Collections.shuffle();
		// 1
		System.out.println(asList.size());
		int[] arr2 = asList.get(0);
		System.out.println(arr2 == arr);// true;
		
		// integer list
		Integer[] arr3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		List<Integer> asList3 = Arrays.asList(arr3);
		Collections.shuffle(asList3);
		
		
		System.out.println(asList3.toString());
		shuffle(arr);
		System.out.println(Arrays.toString(arr));

	}
}
