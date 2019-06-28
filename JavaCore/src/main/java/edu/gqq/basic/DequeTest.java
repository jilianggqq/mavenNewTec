package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class DequeTest {
	@Test
	public void testDeque() throws Exception {
		Deque<String> deque = new LinkedList<>();
		deque.offer("arvind");
		deque.offer("vimal");
		deque.add("mukul");
		deque.addFirst("aaa");
		deque.offerFirst("jia");
		Iterator<String> iterator = deque.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}

		String string = deque.removeLast();
		System.out.println("\n" + string);
	}
}
