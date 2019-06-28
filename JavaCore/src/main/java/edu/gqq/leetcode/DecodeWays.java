package edu.gqq.leetcode;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <br>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1<br>
 * 'B' -> 2<br>
 * ...<br>
 * 'Z' -> 26<br>
 * Given an encoded message containing digits, determine the total number of ways to decode it.<br>
 * 
 * For example,<br>
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).<br>
 * 
 * The number of ways decoding "12" is 2.<br>
 * 
 * Subscribe to see which companies asked this question<br>
 * 
 * Show Tags<br>
 * 
 * @author gqq
 *
 */
public class DecodeWays {
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int result = 1;
		List<String> part = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			while (j < s.length() && s.charAt(j) <= '2' && s.charAt(j) >= '0') {
				j++;
			}
			if (i == j) {
				continue;
			}
			if (j == s.length()) {
				part.add(s.substring(i));
			} else {
				part.add(s.substring(i, j + 1));
			}
			i = j;
		}

		for (int i = 0; i < part.size(); i++) {
			result *= count(part.get(i));
		}
		return result;
		/*
		 * if("".equals(s)||s.startsWith("0"))return 0; if (s.length() == 1 || s.length() == 2) { if (Integer.valueOf(s) > 10 && Integer.valueOf(s) < 27) { return s.contains("0") ?
		 * 1 : 2; } else return s.contains("0") && !"10".equals(s) ? 0 : 1; }
		 * 
		 * if(2<Integer.valueOf(s.charAt(0))&&9>=Integer.valueOf(s.charAt(0))) return numDecodings(s.substring(1)); int num = Integer.valueOf(s.substring(0, 2)); if (num > 10 &&
		 * num < 27) return numDecodings(s.substring(1)) + numDecodings(s.substring(2)); else if (num == 10) { return numDecodings(s.substring(2)); } else return
		 * numDecodings(s.substring(1));
		 */
	}

	public static int count(String s) {
		if ("".equals(s) || s.startsWith("0"))
			return 0;
		if (s.length() == 1 || s.length() == 2) {
			if (Integer.valueOf(s) > 10 && Integer.valueOf(s) < 27) {
				return s.contains("0") ? 1 : 2;
			} else
				return s.contains("0") && !"10".equals(s) ? 0 : 1;
		}

		int num = Integer.valueOf(s.substring(0, 2));
		if (num > 10 && num < 27)
			return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
		else if (num == 10) {
			return numDecodings(s.substring(2));
		} else
			return numDecodings(s.substring(1));
	}

	/**
	 * you can user an array to store the result.<br>
	 * every element in this array is default 0.<br>
	 * if you can use array ,please don't use Recursion.
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodings1(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	public static void main(String[] args) {
		out.println(numDecodings1("30"));
	}
}
