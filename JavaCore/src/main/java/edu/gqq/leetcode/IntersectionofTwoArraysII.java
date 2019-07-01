package edu.gqq.leetcode;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note: Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.<br>
 * Follow up: What if the given array is already sorted? How would you optimize your algorithm?<br>
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?<br>
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once? <br/>
 * Subscribe to see which companies asked this question
 * 
 * @author gqq
 *
 */
public class IntersectionofTwoArraysII {

	/**
	 * wrong answer, I have not finished that.
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		// int num = 0;
		int max = 0;
		ArrayList<Integer> trans = new ArrayList<>();
		ArrayList<Integer> finals = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			trans.clear();
			for (int j = 0; j < len2 && i + j < len1 && nums1[i + j] == nums2[j]; j++)
				trans.add(nums2[j]);

			if (trans.size() > finals.size()) {
				finals.clear();
				finals.addAll(trans);
			}
		}
		return finals.stream().mapToInt(x -> (int) x).toArray();
	}

	public static int[] intersect1(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}

		map.forEach((k, v) -> {
			out.println(String.format("%s---%s", k.toString(), v.toString()));
		});

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}

		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;
	}

	/**
	 * use lambda expression
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect2(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		ArrayList<Integer> result = new ArrayList<Integer>();
		Arrays.stream(nums1).forEach(x -> map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1));
		// the filter is error.
		// it is lack of the filter "map.get(x)>0". If the second array has duplicate numbers, it will be added.
		Arrays.stream(nums2).filter(x -> map.containsKey(x)).forEach(x -> {
			result.add(x);
			map.put(x, map.get(x) - 1);
		});

		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 1 };
		Arrays.stream(intersect1(nums1, nums2)).forEach(x -> out.println(x));
		// out.println(intersect(nums1, nums2));
		// Stream.of(intersect(nums1, nums2)).forEach(x -> out.println(x));
		HashMap<Integer, Integer> tests = new HashMap<>();
		tests.put(1, 2);
		tests.put(2, 3);
		tests.put(1, 8);
		tests.forEach((x, y) -> out.println(x + " --- " + y));

	}
}
