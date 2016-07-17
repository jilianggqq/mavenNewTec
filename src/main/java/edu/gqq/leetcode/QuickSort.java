package edu.gqq.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import edu.gqq.common.G;

public class QuickSort {

	public void quickSort(int l, int h, int[] arrs) {
		if (l >= h)
			return;

		int povit = getPovit(l, h, arrs);
		G.println("povit is " + povit);

		quickSort(l, povit - 1, arrs);
		quickSort(povit + 1, h, arrs);
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
//		Arrays.stream(arrs).forEach(G::println);
		return i;
	}

	@Test
	public void testQuickSort() throws Exception {
		int[] arrs = { 4, 3, 8, 2, 7, 5 };
		quickSort(0, arrs.length - 1, arrs);
		Arrays.stream(arrs).forEach(G::println);
	}
}
