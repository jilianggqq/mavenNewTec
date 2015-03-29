package edu.gqq.thread.synchronizing_on_other_objects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DualSynch {

	private Object o = new Object();
	private Object o2 = new Object();

	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}

	public void h() {
		synchronized (o) {
			for (int i = 0; i < 5; i++) {
				System.out.println("h()");
				Thread.yield();
			}
		}
	}

	public void g() {
		synchronized (o2) {
			for (int i = 0; i < 5; i++) {
				System.out.println("g()");
				// Thread.yield();
			}

		}
	}

}

/**
 * 当使用synchronized(this)时，当一个方法被线程使用时，其它synchronized的方法也不能被其它线程使用。<br>
 * 只有当线程执行出临界区后，其它的线程才能使用。
 * 
 * @author gqq
 *
 */
public class SyncObject {
	public static void main(String[] args) {
		DualSynch ds = new DualSynch();
		ExecutorService exec = Executors.newCachedThreadPool();
		
		new Thread() {
			@Override
			public void run() {
				ds.g();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				ds.h();
			}
		}.start();


		// exec.execute(() -> {
		// ds.g();
		// });
		// exec.execute(() -> {
		// ds.f();
		// });
		ds.f();
	}
}
