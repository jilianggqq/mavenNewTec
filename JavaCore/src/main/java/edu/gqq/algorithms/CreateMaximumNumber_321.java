package edu.gqq.algorithms;

import java.util.Arrays;

public class CreateMaximumNumber_321 {
	
	public static void main(String[] args) {
		CreateMaximumNumber_321 solution = new CreateMaximumNumber_321();
		int[] nums1 = {3, 4, 6, 5};
		int[] nums2 = {9, 1, 2, 5, 8, 3};
		int k = 5;
		int[] maxNumber = solution.maxNumber(nums1, nums2, k);
		System.out.println(Arrays.toString(maxNumber));
	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] ans = new int[k];
		for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
			System.out.println(i);
			int[] res1 = get_max_sub_array(nums1, i);
			int[] res2 = get_max_sub_array(nums2, k - i);
			int[] res = new int[k];
			System.out.println(Arrays.toString(res1));
			System.out.println(Arrays.toString(res2));
			int pos1 = 0, pos2 = 0, tpos = 0;

			// do merge sort for res1 and res2 to combine res
			while (pos1 < res1.length || pos2 < res2.length) {
				res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
			}
			System.out.println(Arrays.toString(res));

			if (!greater(ans, 0, res, 0))
				ans = res;
			System.out.println(Arrays.toString(ans));
			System.out.println();
		}

		return ans;
	}

	public boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
		for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
			if (nums1[start1] > nums2[start2])
				return true;
			if (nums1[start1] < nums2[start2])
				return false;
		}
		return start1 != nums1.length;
	}

	public int[] get_max_sub_array(int[] nums, int k) {
		int[] res = new int[k];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
				len--;
			}
			if (len < k)
				res[len++] = nums[i];
		}
		return res;
	}
}
