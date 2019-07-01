package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAbbreviation_527 {
	public List<String> wordsAbbreviation(List<String> dict) {
		Map<String, String> map = new HashMap<>();
		WordMap2Abbreviation(map, 0, dict);
		List<String> result = new ArrayList<>();
		int size = dict.size();
		for (int i = 0; i < size; i++) {
			result.add(map.get(dict.get(i)));// 调整map中Abbreviation的顺序，使result中的Abbreviation与dict中同一位置上的word相对应
		}
		return result;
	}

	public String getAbbreviation(String word, int fromIndex) {// fromIndex表示从word的第几个字符开始生成缩写词
		int len = word.length();
		if (len - fromIndex <= 3) {// 3个及以下的字符没有缩写的必要
			return word;
		} else {
			return word.substring(0, fromIndex + 1) + String.valueOf(len - fromIndex - 2) + word.charAt(len - 1);
		}
	}

	public void WordMap2Abbreviation(Map<String, String> map, int fromIndex, List<String> dict) {
		Map<String, ArrayList<String>> abbre2Word = new HashMap<>();// 以abbreviation做键，value为Abbreviation相同的word组成的ArrayList<String>
		for (String word : dict) {
			String abbre = getAbbreviation(word, fromIndex);
			if (abbre2Word.containsKey(abbre)) {
				abbre2Word.get(abbre).add(word);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(word);
				abbre2Word.put(abbre, list);
			}
		}
		for (String abbre : abbre2Word.keySet()) {
			ArrayList<String> words = abbre2Word.get(abbre);
			if (words.size() == 1) {// 说明该Abbreviation是unique的
				map.put(words.get(0), abbre);
			} else {
				WordMap2Abbreviation(map, fromIndex + 1, words);// 对这些Abbreviation相同的word递归调用函数
			}
		}
	}
}
