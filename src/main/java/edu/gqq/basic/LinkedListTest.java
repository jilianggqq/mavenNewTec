package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import static java.lang.System.out;

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

	@Test
	public void testFirstElement() throws Exception {
		LinkedList<String> stack = new LinkedList<>();
		// queue.pop
		// queue.getf
		// stack.push("aaa");
		// stack.push("bbb");
		// if no elements in the stack, will return null
		out.println(stack.peek());
		// NoSuchElementException, this is the difference from peek method
//		out.println(stack.getFirst());
	}
}
