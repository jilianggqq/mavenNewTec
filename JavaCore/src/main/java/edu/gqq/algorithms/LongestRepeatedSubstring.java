package edu.gqq.algorithms;

import java.util.Arrays;

public class LongestRepeatedSubstring {
	// return the longest common prefix of s and t
	public static String lcp(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		}
		return s.substring(0, n);
	}

	// return the longest repeated string in s
	public static String lrs(String s) {

		// form the N suffixes
		int n = s.length();
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++) {
			suffixes[i] = s.substring(i, n);
		}
		System.out.println(Arrays.toString(suffixes));
		// sort them
		Arrays.sort(suffixes);
		System.out.println(Arrays.toString(suffixes));

		// find longest repeated substring by comparing adjacent sorted suffixes
		String lrs = "";
		for (int i = 0; i < n - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i + 1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		return lrs;
	}

	// read in text, replacing all consecutive whitespace with a single space
	// then compute longest repeated substring
	public static void main(String[] args) {
		// String s = StdIn.readAll();
		// s = s.replaceAll("\\s+", " ");
		// StdOut.println("'" + lrs(s) + "'");
		String lrs = lrs("ababcab");
		System.out.println(lrs);
		
	}
}
