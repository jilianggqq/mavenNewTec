package edu.gqq.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import static java.lang.System.out;

public class LargestRangle {
	public int largestRectangleArea(int[] heights) {
		Map<Integer, Integer> infos = new HashMap<>();

		if (heights.length == 0)
			return 0;
		if (heights.length == 1)
			return heights[0];

		for (int i = 0; i < heights.length; i++) {
			changeInfo(heights[i], infos);
		}

		// get the max
		int max = 0;
		for (Map.Entry<Integer, Integer> info : infos.entrySet()) {
			int s = info.getKey() * info.getValue();
			max = s > max ? s : max;
		}
		return max;
	}

	private void changeInfo(int value, Map<Integer, Integer> infos) {
		int max = 0;
		for (Map.Entry<Integer, Integer> info : infos.entrySet()) {
			int k = info.getKey();
			int v = info.getValue();
			if (k <= value) {
				infos.put(k, v + 1);
				max = k * (v + 1) > max ? k * (v + 1) : max;
			} else {
				infos.put(value, v + 1);
			}
		}

		if (!infos.containsKey(value)) {
			infos.put(value, 1);
			max = value > max ? value : max;
		}

		for (Map.Entry<Integer, Integer> info : infos.entrySet()) {
			int k = info.getKey();
			int v = info.getValue();
			if (k > value && k * v <= max) {
				infos.remove(k);
			}
		}
	}

	@Test
	public void testHashMap() {
		// use ConcurrentHashMap
		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(1, 2);
		map.put(1, 3);
		map.put(1, 4);
		map.put(2, 5);

		out.println(map.get(1));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// map.put(2, 4);
			// map.put(1, 3);
			// map.put(3, 4);
			map.remove(1);
		}

		map.forEach((k, v) -> {
			out.println(k + "---->" + v);
		});
	}

	@Test
	public void testRemove() {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("aa");
		strings.add("bb");
		strings.add("cc");
		strings.add("dd");
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("bb")) {
				strings.remove(i);
				i--;
			}
		}
		
		for (String string : strings) {
			out.println(string);
		}

	}

}
