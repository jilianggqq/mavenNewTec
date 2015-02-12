package edu.gqq.thread.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		generator = g;
		id = ident;
	}

	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			System.out.println("thread " + id + "'s value is " + val);
			try {
				TimeUnit.MICROSECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (val % 2 != 0) {
				System.out.println("thread " + id + " value is " + val + ", so not even!");
				generator.cancel(); // Cancels all EvenCheckers
			}
		}
	}

	// Test any type of IntGenerator:
	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++)
			exec.execute(new EvenChecker(gp, i));
		exec.shutdown();
	}

	// Default value for count:
	public static void test(IntGenerator gp) {
		// test(gp, 10);
		test(gp, 2);
	}
} // /:~ 