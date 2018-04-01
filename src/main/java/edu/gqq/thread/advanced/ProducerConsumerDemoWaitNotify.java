package edu.gqq.thread.advanced;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerDemoWaitNotify {
	public static void main(String[] args) {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");

		Queue<Integer> buffer = new LinkedList<>();
		Thread producer = new Producer(buffer, 5);
		Thread consumer = new Consumer(buffer);
		producer.start();
		consumer.start();
	}
}

/**
 * * Producer Thread will keep producing values for Consumer * to consumer. It will use wait() method when Queue is full
 * * and use notify() method to send notification to Consumer * Thread. * * @author WINDOWS 8 *
 */

class Producer extends Thread {
	Queue<Integer> queue;
	int maxsize;

	public Producer(Queue<Integer> queue, int max) {
		this.queue = queue;
		maxsize = max;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == maxsize) {
					try {
						System.out.println("queue is full, we need cosumer to cosume it.");
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int val = random.nextInt();
				queue.offer(val);
				System.out.println("we produced " + val);
				
				// it is a lazy producer.
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				queue.notifyAll();
			}
		}
	}
}

/**
 * * Consumer Thread will consumer values form shared queue. * It will also use wait() method to wait if queue is *
 * empty. * It will also use notify method to send * notification to producer thread after consuming values * from
 * queue. * * @author WINDOWS 8 *
 */

class Consumer extends Thread {
	Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("queue is empty, we need producer to produce");
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				int val = queue.poll();
				System.out.println("we consumed " + val);
				queue.notifyAll();
			}
		}
	}
}
