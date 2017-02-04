package edu.gqq.basic;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue<>();
		pq.add("cde");
		pq.add("abc");
		pq.add("bcd");
		pq.remove("bcd");
//		pq.
		for (Object s : pq) {
			System.out.println(s);
		}
	}
}
