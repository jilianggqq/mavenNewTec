package edu.gqq.guava;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

import com.google.common.collect.MinMaxPriorityQueue;

public class MinMaxPriorityQueueTest2 {
	@Test
	public void testName() throws Exception {
		MinMaxPriorityQueue<FIFOCommand> queue = MinMaxPriorityQueue.maximumSize(300).create();
		queue.add(new Command1(1));
		queue.add(new Command1(2));
		queue.add(new Command1(3));
		queue.add(new Command2(1));
		queue.add(new Command2(3));
		queue.add(new Command2(4));

		// queue.add(new Command(4, 1));
		// queue.add(new Command(5, 1));
		// queue.add(new Command(7, 1));
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}

class Command1 extends FIFOCommand {

	public Command1(int id) {
		super(id, 1);
	}
}

class Command2 extends FIFOCommand {

	public Command2(int id) {
		super(id, 2);
	}
}

abstract class FIFOCommand implements Comparable<FIFOCommand> {
	final static AtomicLong seq = new AtomicLong();
	final long seqNum;
	protected int priority;
	protected int id;

	public FIFOCommand(int id, int prio) {
		seqNum = seq.getAndIncrement();
		this.priority = prio;
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("id:%s,priority:%s", id, priority);
	}

	@Override
	public int compareTo(FIFOCommand other) {
		int res = other.priority - this.priority;
		if (res == 0)
			res = (seqNum < other.seqNum ? -1 : 1);
		return res;
	}

}
