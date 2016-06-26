package edu.gqq.leetcode;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.junit.Test;

public class JumpGame {

	@Test
	public void testCanJump4() {
		int[] nums = { 3, 2, 1, 0 };
		int[] nums1 = { 3, 2, 2, 0, 1 };
		int[] nums2 = { 2, 1, 0, 0 };
		int[] nums3= { 1, 0, 1 };
		// canJump2(nums);
		assertTrue(canJump4(nums));
		assertTrue(canJump4(nums1));
		assertFalse(canJump4(nums2));
		assertFalse(canJump4(nums3));
	}
	
	public boolean canJump4(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				// check is it a obstacle
				boolean result = checkOb(i, nums);
				if (!result)
					return false;
			}
		}
		return true;
	}

	public boolean checkOb(int max, int[] nums) {
		for (int i = 1; i < max; i++) {
			if (nums[max - i] > max - i)
				return true;
		}
		return false;
	}

	public boolean canJump3(int[] nums) {
		if (1 == nums.length) {
			return true;
		}
		boolean result = false;
		int i = 0;
		for (; i < nums.length - 1; i++) {
			if (0 == nums[i])
				break;
			if (nums[i] > 0) {
				result = testCanJump(i, nums);
				if (result)
					break;
			}
		}
		if (nums[i] > 0)
			result = true;
		return result;
	}

	private boolean testCanJump(int i, int[] nums) {
		if (i >= nums.length - 1) {
			return true;
		}
		if (nums[i] == 0) {
			return false;
		}
		return testCanJump(i + nums[i], nums);
	}

	@Test
	public void testCanJump3() {
		int[] nums = { 3, 2, 1, 0 };
		int[] nums1 = { 3, 2, 2, 0, 1 };
		int[] nums2 = { 2, 1, 0, 0 };
		// canJump2(nums);
		assertTrue(canJump3(nums));
		assertTrue(canJump3(nums));
		assertTrue(canJump3(nums1));
		assertFalse(canJump3(nums2));
	}

	@Test
	public void testCanJump2() {
		int[] nums = { 3, 2, 1, 0 };
		int[] nums1 = { 3, 2, 2, 0, 1 };
		int[] nums2 = { 2, 1, 0, 0 };
		// canJump2(nums);
		// assertFalse(canJump(nums));
		// assertTrue(canJump(nums));
		// assertTrue(canJump(nums1));
		assertFalse(canJump2(nums2));
	}

	public boolean canJump2(int[] nums) {
		if (1 == nums.length)
			return true;
		if (nums[0] == 0) {
			return false;
		}

		int len = 0;
		boolean needCacul = false;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				len++;
				needCacul = true;
			} else {
				if (needCacul) {
					boolean cannot = true;
					for (int j = 0; j < list.size(); j++) {
						cannot = cannot && (list.get(j) - j <= len);
						if (!cannot)
							break;
					}
					if (cannot)
						return false;
					len = 0;
					list.clear();
					needCacul = false;
				}
				list.add(0, nums[i]);
			}
		}
		if (needCacul) {
			boolean cannot = true;
			for (int j = 0; j < list.size(); j++) {
				cannot = cannot && (list.get(j) - j <= len);
				if (!cannot)
					break;
			}
			if (cannot)
				return false;
			len = 0;
			list.clear();
			needCacul = false;
		}
		return true;

	}

	public boolean canJump(int[] nums) {
		// ArrayList<Integer> zi = new ArrayList<>();
		SortedSet<Integer> zi = new TreeSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				if (i > 0 && nums[i - 1] == 0)
					zi.remove(i - 1);
				zi.add(i);
			}
		}
		if (zi.size() == 0) {
			return true;
		}

		int start = 0;
		for (Integer e : zi) {
			System.out.format("start:%d,end:%d,nums:%s\n", start, e, nums);
			boolean result = checkResult(start, e, nums);
			out.println(result);
			if (!result) {
				return false;
			}
			start = e + 1;
		}
		return true;
	}

	public boolean checkResult(int start, Integer end, int[] nums) {
		while (start < end) {
			if (nums[start] > end - start) {
				return true;
			}
			start++;
		}
		return false;
	}

	@Test
	public void testArrayList() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(1);
		assertEquals(2, (int) arr.get(0));
		arr.clear();
		arr.add(0, 2);
		arr.add(0, 1);
		assertEquals(2, (int) arr.get(1));
		boolean allMatch = IntStream.range(0, 2).allMatch(i -> arr.get(i) - i <= 1);
		assertTrue(allMatch);
	}

	@Test
	public void testCheckResult() {
		int[] nums = { 2, 0, 0 };
		assertTrue(checkResult(0, 1, nums));
	}

	@Test
	public void testJumpGame() {
		int[] num1 = { 2, 3, 1, 1, 4 };
		int[] num2 = { 3, 2, 1, 0, 4 };
		int[] num3 = { 3, 2, 1, 0 };
		int[] num4 = { 3, 2, 2, 0, 4 };
		int[] num5 = { 2, 0, 0 };
		//
		// assertFalse(canJump(num2));
		// assertTrue(canJump(num1));
		// assertTrue(canJump(num3));
		// assertTrue(canJump(num4));
		assertTrue(canJump(num5));
	}

	@Test
	public void testSortedSet() {
		int[] nums = { 3, 0, 0, 0, 2, 7, 0 };
		SortedSet<Integer> zi = new TreeSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				if (i > 0 && nums[i - 1] == 0)
					zi.remove(i - 1);
				zi.add(i);
			}
		}
		assertEquals(1, zi.size());
		assertEquals(3, (int) zi.first());
		// zi.forEach(x -> out.println(x));
	}
}
