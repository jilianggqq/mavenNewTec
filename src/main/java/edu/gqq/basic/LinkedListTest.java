package edu.gqq.basic;

import java.util.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		testQueue();
	}
	
	
	public static void testQueue() {
		LinkedList<String> queue = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			queue.offer("string" + i);
		}
		while (!queue.isEmpty()) {
			String e = queue.poll();
			System.out.println(e);
		}
		
	}
}
