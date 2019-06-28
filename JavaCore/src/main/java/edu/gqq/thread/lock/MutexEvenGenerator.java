package edu.gqq.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import edu.gqq.thread.resource.EvenChecker;
import edu.gqq.thread.resource.IntGenerator;

public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	public int next() {
		// 以下翻译自《java编程思想》<br>
		// 使用lock时，必须使用try—finally语句，并且将unlock放在finally语句中。
		// return必须放在try语句中，这样可以保证不会提前解锁，使别的线程弄脏了临界区中的数据。
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield(); // Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}

	// public static void main(String[] args) {
	// EvenChecker.test(new MutexEvenGenerator());
	// }
} // /:~