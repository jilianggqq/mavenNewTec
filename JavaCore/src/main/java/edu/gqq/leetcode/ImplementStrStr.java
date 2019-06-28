package edu.gqq.leetcode;

import static java.lang.System.out;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Subscribe to see which companies asked this question
 * 
 * @author gqq
 *
 */
public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
		int i = 0;
		for (; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			for (; j < needle.length() && needle.charAt(j) == haystack.charAt(i + j); j++)
				;
			if (j == needle.length())
				break;
		}
		return i <= haystack.length() - needle.length() ? i : -1;
	}

	public static void main(String[] args) {
		out.println(strStr("123", "23"));
	}
}
