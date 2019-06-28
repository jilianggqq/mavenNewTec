package edu.gqq.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * http://www.geeksforgeeks.org/reservoir-sampling/
 * @author gqq
 *
 */
//An efficient Java program to randomly
//select k items from a stream of items
public class ReseviorSampling {

	// A function to randomly select k items from stream[0..n-1].
	public static int[] shuffle(int[] stream, int k, int n) {
		// reservoir[] is the output array. Initialize it with
		// first k elements from stream[]
		int[] res = new int[k];
		// index for elements in stream[]
		int i = 0;
		for (; i < k; i++) {
			res[i] = stream[i];
		}

		Random random = new Random();
		// Iterate from the (k+1)th element to nth element
		for (; i < n; i++) {
			// Pick a random index from 0 to i.
			int idx = random.nextInt(i + 1);
			// If the randomly picked index is smaller than k,
			// then replace the element present at the index
			// with new element from stream
			if (idx < k) {
				res[idx] = stream[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int stream[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int n = stream.length;
		int k = 5;
		int[] res = shuffle(stream, k, n);
		System.out.println(Arrays.toString(res));
	}
}
