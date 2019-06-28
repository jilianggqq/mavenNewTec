package edu.gqq.leetcode;

import static java.lang.System.out;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author gqq
 *
 */
public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		// java.lang.String.split splits on regular expressions, and . in a
		// regular expression means "any character".
		String[] v1s = version1.split("\\.");
		String[] v2s = version2.split("\\.");
		int i = 0;
		for (; i < v1s.length && i < v2s.length; i++) {
			if (Integer.parseInt(v1s[i]) > Integer.parseInt(v2s[i])) {
				return 1;
			} else if (Integer.parseInt(v1s[i]) < Integer.parseInt(v2s[i])) {
				return -1;
			}
		}
		while (i < v1s.length) {
			if (Integer.parseInt(v1s[i]) > 0) {
				return 1;
			}
			i++;
		}
		while (i < v2s.length) {
			if (Integer.parseInt(v2s[i]) > 0) {
				return -1;
			}
			i++;
		}

		return 0;
	}

	/**
	 * best solutions. <br>
	 * 1. use compareTo instead of 1 and 0.<br>
	 * 2. use default value zero.
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion1(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		out.println(compareVersion("1", "0"));
	}
}
