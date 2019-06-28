package edu.gqq.thread.critical_section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalSection {
	// Test the approaches:
	static void testApproaches(PairManager pman) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm = new PairManipulator(pman);
		PairChecker pcheck = new PairChecker(pman);
		// 用一个独立的线程去执行pm
		exec.execute(pm);
		exec.execute(pcheck);
		// 我自己推测的算法
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Sleep interrupted");
			}
			System.out.println(pm);
			// System.exit(0);
		}
	}

	static void testApproaches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1), pm2 = new PairManipulator(pman2);
		PairChecker pcheck1 = new PairChecker(pman1), pcheck2 = new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);

		// 书上经典算法
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Sleep interrupted");
		}
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);

		// 我自己推测的算法
		// while (true) {
		// try {
		// TimeUnit.MILLISECONDS.sleep(500);
		// } catch (InterruptedException e) {
		// System.out.println("Sleep interrupted");
		// }
		// System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		// // System.exit(0);
		// }
	}

	public static void main(String[] args) {
		PairManager pman1 = new PairManager1(), pman2 = new PairManager2();
		PairManager pman3 = new PairManager3(), pman4 = new PairManager4();
		testApproaches(pman1, pman2);
	}

	/**
	 * 该方法将Lock和synchronized的方法放在一起了。
	 * 
	 * @param pman1
	 * @param pman2
	 * @param pman3
	 * @param pman4
	 */
	private static void testApproaches(PairManager pman1, PairManager pman2, PairManager pman3, PairManager pman4) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1), pm2 = new PairManipulator(pman2);
		PairManipulator pm3 = new PairManipulator(pman3), pm4 = new PairManipulator(pman4);
		PairChecker pcheck1 = new PairChecker(pman1), pcheck2 = new PairChecker(pman2);
		PairChecker pcheck3 = new PairChecker(pman3), pcheck4 = new PairChecker(pman4);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pm3);
		exec.execute(pm4);
		exec.execute(pcheck1);
		exec.execute(pcheck2);
		exec.execute(pcheck3);
		exec.execute(pcheck4);

		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Sleep interrupted");
			}
			System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
			System.out.println("pm3: " + pm3 + "\npm4: " + pm4);
			// System.exit(0);
		}
	}
}

/**
 * 不是类安全的类，因为要求x,y必须相等，但是又没有任何synchronized的关键词。
 * 
 * @author gqq
 *
 */
class Pair { // Not thread-safe
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public String toString() {
		return "x: " + x + ", y: " + y;
	}

	public class PairValuesNotEqualException extends RuntimeException {
		public PairValuesNotEqualException() {
			super("Pair values not equal: " + Pair.this);
		}
	}

	// Arbitrary invariant -- both variables must be equal:
	public void checkState() {
		if (x != y)
			throw new PairValuesNotEqualException();
	}
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager {
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		// Make a copy to keep the original safe:
		return new Pair(p.getX(), p.getY());
	}

	// Assume this is a time consuming operation
	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException ignore) {
		}
	}

	public abstract void increment();
}

// Synchronize the entire method:
class PairManager1 extends PairManager {
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

// Use a critical section:
class PairManager2 extends PairManager {
	public void increment() {
		Pair temp;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

/**
 * 直接使用Lock
 * 
 * @author gqq
 *
 */
class PairManager3 extends PairManager {
	private Lock lock = new ReentrantLock();

	public void increment() {
		lock.lock();
		Pair temp;
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}
}

/**
 * 使用Lock锁定全局
 * 
 * @author gqq
 *
 */
class PairManager4 extends PairManager {
	private Lock lock = new ReentrantLock();

	public void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

class PairManipulator implements Runnable {
	private PairManager pm;

	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	public void run() {
		while (true)
			pm.increment();
	}

	public String toString() {
		return pm.getClass().getSimpleName() + ": " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {
	private PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}