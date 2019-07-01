package edu.gqq.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidPerfectSquare_367 {
    public static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        long low = 0, hi = num;
        while (low <= hi) {
            long mid = low + (hi - low) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                low = mid + 1l;
            } else {
                hi = mid - 1l;
            }
        }
        return false;
    }
//    @Test
//	public void testPS() throws Exception {
//		assertFalse(isPerfectSquare(2147483647));
//	}
    public static void main(String[] args) {
		System.out.println(ValidPerfectSquare_367.isPerfectSquare(2147483647));
	}
}
