package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class QueueTest {
	@Test
	public void testQueueArray() throws Exception {
		Queue<int[]> queue = new LinkedList<>();
		int[] arr1 = { 1, 2 };
		int[] arr2 = { 3, 4 };
		queue.offer(arr1);
		queue.offer(arr2);
		queue.offer(new int[] { 7, 8 });
		while (!queue.isEmpty()) {
			 System.out.println(queue.poll()[0]);
			// ass
		}
	}
}
