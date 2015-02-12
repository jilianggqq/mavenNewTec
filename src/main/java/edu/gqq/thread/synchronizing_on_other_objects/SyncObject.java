package edu.gqq.thread.synchronizing_on_other_objects;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DualSynch {

	private Object o = new Object();
	private Object o2 = new Object();

	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			Thread.yield();
			System.out.println("f()");
		}
	}

	public void h() {
		synchronized (o) {
			for (int i = 0; i < 5; i++) {
				Thread.yield();
				System.out.println("h()");
			}
		}
	}

	public void g() {
		synchronized (o2) {
			for (int i = 0; i < 5; i++) {
				Thread.yield();
				System.out.println("g()");
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
				ds.f();
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				ds.h();
			}
		}.start();


//		exec.execute(() -> {
//			ds.h();
//		});
		// exec.execute(() -> {
		// ds.f();
		// });
		ds.g();
	}
}
