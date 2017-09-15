package edu.gqq.algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Association_Amazon {
	public static void main(String[] args) {
		String[][] ass = {{"itemA", "itemB"}, {"itemB", "itemC"}, {"itemG", "itemD"}, {"itemD", "itemF"}};
		String[] reStrings = maxAssociation(ass);
		for (String string : reStrings) {
			System.out.println(string);
		}
	}
	public static String[] maxAssociation(String[][] associations) {
		Map<String, String> map = new HashMap<>();
		for (String[] strings : associations) {
			if (!map.containsKey(strings[0])) {
				map.put(strings[0], strings[0]);
			}
			if (!map.containsKey(strings[1])) {
				map.put(strings[1], strings[1]);
			}
		}

		for (String[] strings : associations) {
			// find
			String parent0 = map.get(strings[0]);
			String parent1 = map.get(strings[1]);
			if (parent0 != parent1) {
				// union
				for (String key : map.keySet()) {
					if (map.get(key).equals(parent1)) {
						map.put(key, parent0);
					}
				}
			}
		}

		Map<String, Integer> countMap = new HashMap<>();
		for (String parent : map.values()) {
			countMap.put(parent, countMap.getOrDefault(parent, 0) + 1);
		}

		int max = 0;
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}

		String maxParent = "";
		for (String[] strings : associations) {
			if (countMap.get(map.get(strings[0])) == max) {
				maxParent = map.get(strings[0]);
				break;
			}
			if (countMap.get(map.get(strings[1])) == max) {
				maxParent = map.get(strings[0]);
				break;
			}
		}

		List<String> list = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key).equals(maxParent)) {
				list.add(key);
			}
		}

		Collections.sort(list);
		String[] res = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
