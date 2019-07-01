package edu.gqq.algorithms;

public class MaxSubSequence {
	public static int getMax(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], nums[0] + nums[1]);
		int res = Math.max(dp[0], dp[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(nums[i], Math.max(nums[i] + dp[i - 1], nums[i] + dp[i - 2]));
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, -1, -2, 3, 4};
		System.out.println(getMax(nums));
	}
}
