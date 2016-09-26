package edu.gqq.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
 * 
 * @author peter
 *
 */
public class KMPDemo {

	/**
	 * this method should be recited.
	 * 
	 * @param s
	 * @return
	 */
	public int[] getNextTable(String s) {
		int len = s.length();
		int[] next = new int[len];
		int k = -1;
		next[0] = -1;
		int j = 0;
		while (j < len - 1) {
			if (k == -1 || s.charAt(j) == s.charAt(k)) {
				++k;
				++j;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

	public int getFirstIndex(String des, String src) {
		int len1 = src.length();
		int len2 = des.length();
		int[] next = getNextTable(des);
		for (int i = 0; i < next.length; i++) {
			System.out.print(next[i]+" ");
		}
		System.out.println();
		int i = 0, j = 0;
		while (i < len1 && j < len2) {
			System.out.println(String.format("{i:%s, j:%s}", i, j));
			if (j == -1 || src.charAt(i) == des.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
			}
		}
		if (j == len2) {
			return i - j;
		}
		return -1;
	}


	@Test
	public void testKMPDemo() throws Exception {
		int[] des = { -1, 0, 0, 0, 1 };
		assertArrayEquals(des, getNextTable("abcab"));
		int[] des2 = { -1, 0, 0, 0, 0, 1, 2 };
		assertArrayEquals(des2, getNextTable("ABCDABD"));
	}
	
	@Test
	public void testStringMatch() throws Exception {
		String str1 = "bbcabcdababcdabcdabde";
		String str2 = "abcdabd";
		int index = getFirstIndex(str2, str1);
		assertEquals(13, index);
	}
}
