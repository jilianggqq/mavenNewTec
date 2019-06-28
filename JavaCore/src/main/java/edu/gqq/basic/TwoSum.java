package edu.gqq.basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {
		// throw new UnsupportedOperationException("Waiting to be implemented.");
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = { -1, -1 };

		for (int i = 0; i < list.length; i++) {
			int num = list[i];
			if (map.containsKey(sum - num)) {
				res[0] = map.get(sum - num);
				res[1] = i;
				break;
			} else {
				map.put(num, i);
			}
		}
		return res[0] == -1 ? null : res;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
		System.out.println(indices[0] + " " + indices[1]);
	}
}