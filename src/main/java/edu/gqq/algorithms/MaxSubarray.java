package edu.gqq.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubarray {
	/**
	 * Kadane算法(卡登算法)
	 * 
	 * @param arr
	 * @return
	 */
	public int max_subarray(int[] arr) {
		int max_ending_here = 0;
		int max_so_far = 0;
		for (int v : arr) {
			max_ending_here = Math.max(0, max_ending_here + v);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

	/**
	 * 从动态规划的角度看，Base case： 我们首先建立一个与原数列A长度相同的数列dp，dp中的每一个值dp[i]表示以位置i为终点的子数列的最大和。Induction case：
	 * 如果以前面一个位置为结束的子数列和为正数，既dp[i-1]>0,那么dp[i]=dp[i-1]+A[i]；否则dp[i]=A[i]。那么dp[n]就是我们想要的该数列的最大连续子数列之和。算法代码如下：
	 * 
	 * @param arr
	 * @return
	 */
	public int max_subarray_dp(int[] arr) {
		int[] dp = arr.clone();
		int max_so_far = 0;
		for (int i = 1; i < arr.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + arr[i];
			}
			max_so_far = Math.max(max_so_far, dp[i]);
		}
		return max_so_far;
	}

	@Test
	public void testMaxSub() throws Exception {
		assertEquals(3, max_subarray(new int[] { -1, 3, -2 }));
		assertEquals(5, max_subarray(new int[] { -1, 3, -2, 4 }));
		assertEquals(6, max_subarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		assertEquals(3, max_subarray_dp(new int[] { -1, 3, -2 }));
		assertEquals(5, max_subarray_dp(new int[] { -1, 3, -2, 4 }));
		assertEquals(6, max_subarray_dp(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
