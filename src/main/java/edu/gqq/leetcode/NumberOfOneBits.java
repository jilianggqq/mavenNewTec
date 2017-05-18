package edu.gqq.leetcode;

import org.apache.log4j.Logger;

import edu.gqq.common.Log4jUtil;

public class NumberOfOneBits {
	static Logger logger = Log4jUtil.getLogger(NumberOfOneBits.class);

	public static void main(String[] args) {
		String ten = Integer.toBinaryString(10);
		String ten2 = Integer.toBinaryString(-10);
		String s3 = Integer.toBinaryString(-2147483648);
		String s4 = Integer.toBinaryString(-2147483647);
		String s5 = Integer.toBinaryString(-2147483647 >>> 20);
		String s6 = Integer.toBinaryString(-2147483647 >> 20);
		logger.debug(String.format("s3:%s, s4:%s, s5:%s,s6:%s", s3, s4, s5, s6));
		logger.debug((int) ('1'));
		logger.debug(Character.getNumericValue('1'));
		// Integer.va
		logger.debug(7 & 1);

		int n = 7;
		int result = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				result++;
			n = n >>> 1;
		}
		// return result;
	}
}
