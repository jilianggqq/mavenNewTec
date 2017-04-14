package edu.gqq.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveBoxes {
	public int removeBoxes(int[] boxes) {
		Map<String, Integer> cache = new HashMap<>();
		return helper(boxes, cache);
	}

	public int helper(int[] boxes, Map<String, Integer> cache) {
		if (boxes.length == 0)
			return 0;
		if (boxes.length == 1)
			return 1;
		String key = Arrays.toString(boxes);
		if (cache.containsKey(key))
			return cache.get(key);
		int n = boxes.length;
		int st = 1;
		while (st < n && boxes[st] == boxes[st - 1])
			st++;
		if (st == n) {
			cache.put(key, n * n);
			return n * n;
		}
		int max = 0;
		int i = 0, j = 1;
		while (j <= n) {
			if (j == n || boxes[i] != boxes[j]) {
				int m = n - (j - i);
				int[] newboxes = new int[m];
				int k = 0;
				for (int t = 0; t < i; t++)
					newboxes[k++] = boxes[t];
				for (int t = j; t < n; t++)
					newboxes[k++] = boxes[t];
				max = Math.max(max, (j - i) * (j - i) + removeBoxes(newboxes));
				i = j;
			}
			j++;
		}
		cache.put(key, max);
		return max;
	}
	public static void main(String[] args) {
		RemoveBoxes rb = new RemoveBoxes();
		int[] boxes = {3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7};
		int res = rb.removeBoxes(boxes);
		System.out.println(res);
	}
}
