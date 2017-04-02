package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import edu.gqq.common.G;

public class ReverseBitsTest {
	public static void main(String[] args) {
		long res = reverseBits(2147483648l);
		G.println(res);
//		Stack<String> stack = new LinkedList<String>();
		
	}

	// you need treat n as an unsigned value
	public static long reverseBits(long n) {
		long res = 0;
		long newn = n;
		for (int i = 0; i < 32; i++) {
			long rm = newn % 2;
//			System.out.println(rm);
			res = (res << 1) | rm;
//			System.out.println(res);
			newn /= 2;
		}
		return (int) res;
	}
}
