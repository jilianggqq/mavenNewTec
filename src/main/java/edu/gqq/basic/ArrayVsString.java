package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import edu.gqq.common.G;

public class ArrayVsString {
	@Test
	public void testConvertion() throws Exception {
		int[] arr = { 3, 4, 7, 2, 8 };
		String string = Arrays.toString(arr);
		G.println(string);
		String[] arr2 = string.split(",");
		Arrays.stream(arr2).forEach(x -> G.print(x + " "));
		G.println();
	}

	@Test
	public void arrQueue() throws Exception {
		Queue<int[]> queue = new LinkedList<>();
		int[] arr = { 3, 2, 1 };
		queue.offer(arr);
		int[] arr2 = new int[arr.length];

		System.arraycopy(arr, 0, arr2, 0, arr.length);
		arr2[2] = 100;
		queue.offer(arr2);
		while (!queue.isEmpty()) {
			int[] res = queue.poll();
			G.println(Arrays.toString(res));
		}
	}
}
