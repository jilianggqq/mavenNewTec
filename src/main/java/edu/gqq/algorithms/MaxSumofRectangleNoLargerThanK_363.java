package edu.gqq.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

/**
 * http://www.programcreek.com/2014/08/leetcode-max-sum-of-rectangle-no-larger-than-k-java/
 * @author gqq
 * it is a very clever method to solve this problem.
 */
public class MaxSumofRectangleNoLargerThanK_363 {
	@Test
	public void testMax() throws Exception {
		int[][] m = {
		  {1,  0, 1},
		  {0, -2, 3}
		};
		int ret = maxSumSubmatrix(m, 2);
		assertEquals(2, ret);
	}
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int row = matrix.length;
		int col = matrix[0].length;

		int m = Math.max(row, col);
		int n = Math.min(row, col);
		boolean isRowLarger = false;
		if (row > col)
			isRowLarger = true;

		int result = Integer.MIN_VALUE;

		for (int c1 = 0; c1 < n; c1++) {

			int[] each = new int[m];
			for (int c2 = c1; c2 >= 0; c2--) {

				for (int r = 0; r < m; r++) {
					each[r] += isRowLarger ? matrix[r][c2] : matrix[c2][r];
				}
				System.out.println(Arrays.toString(each));
				int tmp = getLargestSumCloseToK(each, k);
				System.out.println(tmp);
				result = Math.max(result, tmp);
				System.out.println(result);
			}
		}

		return result;
	}

	@Test
	public void testGetClose() throws Exception {
		int[] arr = {0, -1, 4, -1};
		int res = getLargestSumCloseToK(arr, 1);
		assertEquals(0, res);
	}

	// http://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/
	public int getLargestSumCloseToK(int[] arr, int k) {
		int sum = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		int result = Integer.MIN_VALUE;
		set.add(0);

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			Integer ceiling = set.ceiling(sum - k);
			if (ceiling != null) {
				result = Math.max(result, sum - ceiling);
			}

			set.add(sum);
		}

		return result;
	}
}
