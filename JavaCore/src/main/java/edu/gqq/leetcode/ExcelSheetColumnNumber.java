package edu.gqq.leetcode;

import static java.lang.System.out;

/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 <br>
 * B -> 2<br>
 * C -> 3<br>
 * Z -> 26 <br>
 * AA -> 27 <br>
 * AB -> 28
 * <p>
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 * 
 * Subscribe to see which companies asked this question
 * 
 * @author gqq
 *
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		char[] cColums = s.toCharArray();
		int sum = 0;
		int len = cColums.length;
		for (int i = 0; i < len; i++) {
			sum += Math.pow(26, len - (i + 1)) * (Character.getNumericValue(cColums[i]) - 9);
		}
		return sum;
	}

	/**
	 * 1. use charAt(i) instead of Character.getNumericValue<br>
	 * 2. use charAt() is more efficiency than toCharArray.
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber1(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		char a = 'B';
		out.println(Character.getNumericValue(a));
		char[] cColums = "ABC".toCharArray();
		for (char c : cColums) {
			out.print(c + "  ");
		}
		out.println();

		out.println(titleToNumber("ZZ"));
	}
}
