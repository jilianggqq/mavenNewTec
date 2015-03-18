package edu.gqq.thread.synchronizing_on_other_objects;

public class SynchronizationTest2 {
	public static void main(String args[]) {

		PrintDemo PD = new PrintDemo();

		ThreadDemo T1 = new ThreadDemo("Thread - 1 ", PD);
		ThreadDemo T2 = new ThreadDemo("Thread - 2 ", PD);

		T1.start();
		T2.start();

		// wait for threads to end
		try {
			T1.join();
			T2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}

class PrintDemo {
	private static int number = 1000;

	public synchronized void printCount() {
		try {
			// while (number-- > 0)
			// System.out.println("Counter   ---   " + number + " thread:" +
			// Thread.currentThread().getName());
			for (int i = 5; i > 0; i--) {
				System.out.println("Counter   ---   " + i + " thread:" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}

}

class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo PD;

	ThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		PD = pd;
	}

	public void run() {
		// 上面一种写法和下面一种写法是一样的。
		// synchronized (PD) {
		// PD.printCount();
		// }
		PD.printCount();
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
