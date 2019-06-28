package edu.gqq.thread.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GqqSubChecker implements Runnable {
	private GqqSubGen generator;

	public GqqSubChecker(GqqSubGen g) {
		generator = g;
	}

	@Override
	public void run() {
		// Thread.currentThread().getName()
		while (true) {

			generator.add();
			// try {
			// TimeUnit.SECONDS.sleep(2);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			if (generator.getY() - generator.getX() > 1) {
				System.out.println(generator.getX() + " " + generator.getY());
				break;
			}
		}
	}

	// Test any type of IntGenerator:
	public static void test(GqqSubGen gp, int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++)
			exec.execute(new GqqSubChecker(gp));
		exec.shutdown();
	}

	// Default value for count:
	public static void test(GqqSubGen gp) {
		test(gp, 3);
	}
}
