package edu.gqq.algorithms;

import static org.junit.Assert.*;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class WordDictionary {
	Set<String> set = new HashSet<>();
	Map<Integer, Set<String>> lenMap = new HashMap<>();
	List<Map<Integer, Set<String>>> list = new ArrayList<>();

	public WordDictionary() {
		for (int i = 0; i < 26; i++) {
			list.add(new HashMap<>());
		}
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		// set.add(word);
		int len = word.length();
		if (lenMap.containsKey(len)) {
			lenMap.get(len).add(word);
		} else {
			Set<String> set = new HashSet<>();
			set.add(word);
			lenMap.put(len, set);
		}

		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			Map<Integer, Set<String>> map = list.get(c - 'a');
			if (map.containsKey(i)) {
				map.get(i).add(word);
			} else {
				Set<String> set = new HashSet<>();
				set.add(word);
				map.put(i, set);
			}
		}

	class TreNode {
		TreNode[] nodes = new TreNode[26];
		String elem;
	}

	TreNode root = new TreNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		TreNode node = root;
		for (Character c : word.toCharArray()) {
			if (node.nodes[c - 'a'] == null) {
				node.nodes[c - 'a'] = new TreNode();
			}
			node = node.nodes[c - 'a'];
		}
		node.elem = word;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		out.println("word is " + word);
		lenMap.forEach((k, v) -> {
			out.println(k);
			out.println(v);
		});
		out.println("****************************************");
		int len = word.length();
		Set<String> lenSet = lenMap.get(len);
		if (null == lenSet || lenSet.size() == 0) {
			return false;
		}
		Set<String> newSet = new HashSet<>(lenSet);
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			if (c != '.') {
				Map<Integer, Set<String>> map = list.get(c - 'a');
				if (null == map || map.get(i) == null) {
					return false;
				}
				newSet.retainAll(map.get(i));
				if (newSet.size() == 0)
					return false;
			}
		}
		if (newSet.size() == 0)
			return false;
		return true;
	}

	@Test
	public void testWD3() throws Exception {
		WordDictionary wd = new WordDictionary();

		wd.addWord("at");
		wd.addWord("and");
		wd.addWord("an");
		wd.addWord("add");
		assertFalse(wd.search("a"));
		assertFalse(wd.search(".at"));
		wd.addWord("bat");
		assertTrue(wd.search(".at"));
		assertTrue(wd.search("an."));
		assertFalse(wd.search("a.d."));
		assertFalse(wd.search("b."));
		assertTrue(wd.search("a.d"));
		assertFalse(wd.search("."));

	}

	@Test
	public void testWD() throws Exception {
		WordDictionary wd = new WordDictionary();
		wd.addWord("abc");
		assertTrue(wd.search("abc"));
		assertTrue(wd.search("ab."));
		assertTrue(wd.search("a.c"));
		assertTrue(wd.search(".bc"));
		assertTrue(wd.search("..c"));
		assertTrue(wd.search("..."));
		assertFalse(wd.search("."));
		assertFalse(wd.search("...."));
		assertFalse(wd.search("bc"));
	}

	@Test
	public void testWD2() throws Exception {
		WordDictionary wd = new WordDictionary();
		wd.addWord("a");
		wd.addWord("ab");
		assertTrue(wd.search("a"));
		assertTrue(wd.search("a."));
		assertTrue(wd.search("ab"));
		assertFalse(wd.search(".a"));
		assertTrue(wd.search(".b"));
		assertFalse(wd.search("ab."));
		assertTrue(wd.search("."));
		assertTrue(wd.search(".."));
		return doSearch(0, root, word, word.length());
	}

	public boolean doSearch(int i, TreNode node, String word, int len) {
		if (node == null) {
			return false;
		}
		if (i == len) {
			return node.elem == null ? false : true;
		}
		char c = word.charAt(i);
		if (c != '.') {
			TreNode subNode = node.nodes[c - 'a'];
			return doSearch(i + 1, subNode, word, len);
		} else {
			for (TreNode subNode : node.nodes) {
				boolean res = doSearch(i + 1, subNode, word, len);
				if (res) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Test
	public void testWD() throws Exception {
		WordDictionary wd = new WordDictionary();
		wd.addWord("a");
		assertTrue(wd.search("a"));
		assertTrue(wd.search("."));
		assertFalse(wd.search(".a"));
		wd.addWord("aaef");
		assertTrue(wd.search("a.ef"));
		assertTrue(wd.search("a..f"));
		assertFalse(wd.search("..."));
	}
}
