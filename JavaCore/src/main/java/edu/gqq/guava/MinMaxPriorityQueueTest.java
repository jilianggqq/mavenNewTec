package edu.gqq.guava;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

import com.google.common.collect.MinMaxPriorityQueue;

public class MinMaxPriorityQueueTest {
	@Test
	public void testName() throws Exception {
		MinMaxPriorityQueue<FIFOEntry<Command>> queue = MinMaxPriorityQueue.maximumSize(300).create();
		queue.add(new FIFOEntry<Command>(new Command(3, 1)));
		queue.add(new FIFOEntry<Command>(new Command(7, 1)));
		queue.add(new FIFOEntry<Command>(new Command(5, 1)));
		queue.add(new FIFOEntry<Command>(new Command(4, 1)));
		queue.add(new FIFOEntry<Command>(new Command(4, 2)));
		queue.add(new FIFOEntry<Command>(new Command(4, 3)));
		queue.add(new FIFOEntry<Command>(new Command(19, 1)));

		// queue.add(new Command(4, 1));
		// queue.add(new Command(5, 1));
		// queue.add(new Command(7, 1));
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().getEntry());
		}
	}
}

class FIFOEntry<E extends Comparable<? super E>> implements Comparable<FIFOEntry<E>> {
	final static AtomicLong seq = new AtomicLong();
	final long seqNum;
	final E entry;

	public FIFOEntry(E entry) {
		seqNum = seq.getAndIncrement();
		this.entry = entry;
	}

	public E getEntry() {
		return entry;
	}

	public int compareTo(FIFOEntry<E> other) {
		int res = entry.compareTo(other.entry);
		if (res == 0 && other.entry != this.entry)
			res = (seqNum < other.seqNum ? -1 : 1);
		return res;
	}
}

class Command implements Comparable<Command> {

	private int priority;
	private int id;

	public Command(int id, int prio) {
		this.priority = prio;
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("id:%s,priority:%s", id, priority);
	}

	@Override
	public int compareTo(Command o) {
		return o.priority - this.priority;
	}

}
