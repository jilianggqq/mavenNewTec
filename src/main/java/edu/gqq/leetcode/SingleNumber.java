package edu.gqq.leetcode;

import java.util.Arrays;

import org.apache.log4j.Logger;

import edu.gqq.util.Log4jUtil;

public class SingleNumber {
	static Logger logger = Log4jUtil.getLogger(SingleNumber.class);

	int result;

	public int singleNumber(int[] nums) {
		// you must understand xor
		// n^n=0, n^0=n
		Arrays.stream(nums).forEach(x -> result ^= x);
		return result;
	}

	public static void main(String[] args) {
		logger.debug(4 ^ 4);
		logger.debug(4 ^ 3);
		logger.debug(4 ^ 0);
		logger.debug(114 ^ 0);
		logger.debug(4 ^ 3 ^ 4 ^ 3);
		int[] a = { 1, 1, 2, 2, 3 };
		logger.debug(new SingleNumber().singleNumber(a));

		int a1 = 3;
		int b1 = 4;
		a1 = a1 ^ b1;
		b1 = a1 ^ b1;
		a1 = b1 ^ a1;
		logger.debug(b1);
		logger.debug(a1);
	}
}
