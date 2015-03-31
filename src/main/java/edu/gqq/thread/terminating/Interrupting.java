package edu.gqq.thread.terminating;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		out.println("Interrupting " + r.getClass().getName());
		// 特别注意，只有sleep的线程才是可以被终止的，其余的线程不能够被终止。
		f.cancel(true); // Interrupts if running
		out.println("Interrupt sent to " + r.getClass().getName());
	}

	public static void main(String[] args) throws Exception {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		out.println("Aborting with System.exit(0)");
		System.exit(0); // ... since last 2 interrupts failed
	}
}

class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		out.println("SynchronizedBlocked:" + Thread.currentThread().getName() + " is running");
		while (true)
			// Never releases lock
			Thread.yield();
	}

	// 在构造函数中，运行一个线程，锁住f函数，当run运行的时候，就会发生线程的blocked
	// 这是两个线程的节奏
	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f(); // Lock acquired by this thread
			}
		}.start();
	}

	public void run() {
		out.println("Trying to call f()");
		out.println("SynchronizedBlocked:" + Thread.currentThread().getName() + " is blocked.");
		f();
		out.println("Exiting SynchronizedBlocked.run()");
	}
}

class SleepBlocked implements Runnable {
	public void run() {
		try {
			// TimeUnit.SECONDS.sleep(100);
			// TimeUnit.MILLISECONDS.sleep(20);
			int count = 0;
			while (true) {
				out.println("cycling..." + count++);
			}

			// } catch (InterruptedException e) {
		} catch (Exception e) {
			out.println("InterruptedException");
		}
		out.println("Exiting SleepBlocked.run()");
	}
}

class IOBlocked implements Runnable {
	private InputStream in;

	public IOBlocked(InputStream is) {
		in = is;
	}

	public void run() {
		try {
			out.println("Waiting for read():");
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				out.println("Interrupted from blocked I/O");
			} else {
				throw new RuntimeException(e);
			}
		}
		out.println("Exiting IOBlocked.run()");
	}
}