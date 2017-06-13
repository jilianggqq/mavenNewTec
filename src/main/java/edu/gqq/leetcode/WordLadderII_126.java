package edu.gqq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII_126 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("dot","dog","lot","log","cog");
		List<List<String>> ladders = findLadders("hot", "cog", list);
		System.out.println(ladders.toString());
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<>(wordList);
		Map<String, List<List<String>>> cache = new HashMap<>();
		return helper(beginWord, endWord, wordset, cache);
	}

	public static List<List<String>> helper(String begin, String end, Set<String> wordset, Map<String, List<List<String>>> cache) {
		 if (cache.containsKey(begin)) {
			 return cache.get(begin);
		 }
		List<List<String>> res = new ArrayList<>();
		if (begin.equals(end)) {
			List<String> elem = new ArrayList<>();
			elem.add(begin);
			res.add(elem);
			cache.put(begin, res);
			return res;
		}

		Set<String> neibours = getNeibours(begin, wordset);
		for (String nb : neibours)
			wordset.remove(nb);
		// System.out.println("************ begin : "+ begin +"*********");
		// if (begin.equals("hot")) {
		// neibours.forEach(x -> System.out.println(x));
		// }
		for (String nb : neibours) {
			// System.out.println(nb);
			List<List<String>> subres = helper(nb, end, new HashSet<>(wordset), cache);
			for (List<String> sub : subres) {
				List<String> elem = new ArrayList<>();
				elem.add(begin);
				elem.addAll(sub);
				res.add(elem);
			}
		}
		// System.out.println("************ end : "+ begin +"*********");
		 cache.put(begin, res);
		return res;
	}

	public static Set<String> getNeibours(String begin, Set<String> wordset) {
		Set<String> res = new HashSet<>();
		char[] arr = begin.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char pre = arr[i];
			for (char j = 'a'; j <= 'z'; j++) {
				if (j == pre)
					continue;
				arr[i] = j;
				if (wordset.contains(String.valueOf(arr))) {
					res.add(String.valueOf(arr));
				}
			}
			arr[i] = pre;
		}
		return res;
	}
}
