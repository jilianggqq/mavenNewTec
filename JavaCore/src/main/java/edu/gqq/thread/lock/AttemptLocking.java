package edu.gqq.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();

	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally {
			if (captured)
				lock.unlock();
		}
	}

	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
		} finally {
			if (captured)
				lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final AttemptLocking al = new AttemptLocking();
		// al.untimed(); // True -- lock is available
		// al.timed(); // True -- lock is available
		// Now create a separate task to grab the lock:
		new Thread() {
			{
				setDaemon(true);
			}

			public void run() {
				al.lock.lock();
				System.out.println("acquired");
				// try {
				// TimeUnit.MICROSECONDS.sleep(150000);
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } finally {
				// al.lock.unlock();
				// }
			}
		}.start();
		// 在Java编程思想这本书中，使用了yield，但是这个不太好，如果计算机执行比较快，下面还是会输出两个true
		// 使用sleep，调整时间，可以更好的实现两个FALSE
		// Thread.yield(); // Give the 2nd task a chance
		TimeUnit.MICROSECONDS.sleep(2000);
		al.untimed(); // False -- lock grabbed by task
		al.timed(); // False -- lock grabbed by task
	}
}
