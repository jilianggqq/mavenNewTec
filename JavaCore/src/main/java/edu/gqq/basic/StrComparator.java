package edu.gqq.basic;

import static org.junit.Assert.*;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class StrComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		char[] charo1 = o1.toCharArray();
		char[] charo2 = o2.toCharArray();
		Arrays.sort(charo1);
		Arrays.sort(charo2);
		int i = 0, j = 0;
		while (i < charo1.length && j < charo2.length) {
			if (charo1[i] < charo2[j]) {
				i++;
			} else if (charo1[i] > charo2[j]) {
				j++;
			} else {
				return 0;
			}
		}
		return o1.length() * o2.length();
	}

	@Test
	public void testCompare() throws Exception {
		assertEquals(compare("ab", "abc"), 0);
		assertEquals(compare("abc", "xyz"), 9);
		assertEquals(compare("abcdef", "abcw"), 0);
	}

	@Test
	public void testCharToInt() throws Exception {
		int i = 0;
		String tmp = "a";
		for (int j = 0; j < tmp.length(); j++) {
			i |= 1 << (tmp.charAt(j) - 'a');
		}

		out.println(1 << 1);
		out.println(i);
	}
}
