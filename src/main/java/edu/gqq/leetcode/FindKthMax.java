package edu.gqq.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.sun.org.apache.regexp.internal.recompile;

import edu.gqq.common.G;

public class FindKthMax {

	@Test
	public void testfindKthMax() throws Exception {
		int[] s = { 3, 2, 8, 15, 1, 7 };
		int index = findKthMax(s, 3, 0, s.length - 1);
		// int index = findKthMax(s, 0, 0, s.length - 1);
		G.println(index);
	}

	int x = 0;

	public int findKthMax(int[] s, int k, int start, int end) {
		if (k > s.length)
			return -1;

//		if (x++ > 1) {
//			return 0;
//		}

		// do one cycle quick sort
		int p = getPovit(start, end, s);
		G.println(String.format("k is %d, p is %d, start is %d, end is %d", k, p, start, end));
		Arrays.stream(s).forEach(x -> G.print("  " + x));
		G.println();
		if (p == k)
			return s[p];
		// if(p>k), find from left, the kth
		if (p > k) {
			return findKthMax(s, k, start, p - 1);
		} else {
			return findKthMax(s, k, p + 1, end);
		}
		// return 0;
	}

	private int getPovit(int i, int j, int[] arrs) {
		int p = arrs[i];
		while (i < j) {
			while (i < j && arrs[j] >= p) {
				--j;
			}
			if (i < j) {
				arrs[i++] = arrs[j];
			}

			while (i < j && arrs[i] <= p) {
				++i;
			}
			if (i < j) {
				arrs[j--] = arrs[i];
			}
		}

		arrs[i] = p;
		return i;
	}
}
