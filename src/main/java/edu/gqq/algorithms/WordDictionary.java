package edu.gqq.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordDictionary {

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
