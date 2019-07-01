package edu.gqq.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumGeneticMutation {
	public static void main(String[] args) {
		MinimumGeneticMutation mg = new MinimumGeneticMutation();
		System.out.println(mg.minMutation("AACCGGTT", "AAACGCTA", new String[] {"AACCGGTA","AAACGCTA","AAACGGTA" }));
	}

	public int minMutation(String start, String end, String[] bank) {
		Map<Integer, Character> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		Arrays.stream(bank).forEach(x -> set.add(x));
		char[] startArr = start.toCharArray();
		char[] endArr = end.toCharArray();
		for (int i = 0; i < 8; i++) {
			if (startArr[i] != endArr[i]) {
				map.put(i, endArr[i]);
			}
		}

		return doMin(startArr, endArr, map, set);
	}

	private int doMin(char[] startArr, char[] endArr, Map<Integer, Character> map, Set<String> set) {
		if (Arrays.equals(startArr, endArr))
			return 0;
		for (Map.Entry<Integer, Character> m : map.entrySet()) {
			char[] newStart = startArr.clone();
			int k = m.getKey();
			char v = m.getValue();
			newStart[k] = v;
			String newString = String.valueOf(newStart);
			if (set.contains(newString)) {
				Map<Integer, Character> newMap = new HashMap<>(map);
				newMap.remove(k);
				int res = doMin(newString.toCharArray(), endArr, newMap, set);
				if (res != -1) {
					return 1 + res;
				}
			}
		}
		return -1;
	}
}
