package edu.gqq.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import edu.gqq.common.G;

public class AtomicityTest implements Runnable {
	private int i = 0;

	public int getValue() {
		return i;
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	@Override
	public void run() {
		while (true)
			evenIncrement();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService tPool = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		tPool.execute(at);

		while (true) {
			// type type = (type) en.nextElement();
			// TimeUnit.MILLISECONDS.sleep(100);
			int value = at.getValue();
			G.println("value is " + value);
			if (value % 2 != 0) {
				G.println("Now the value is " + value);
				System.exit(0);
			}
		}
	}
}
