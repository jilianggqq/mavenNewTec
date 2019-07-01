package edu.gqq.thread.damon;

import java.util.concurrent.TimeUnit;

import edu.gqq.common.G;
import edu.gqq.common.GqqBase;

/*
 * Daemon threads don’t prevent the program from ending
 * Daemon threads在主线程结束之后就结束了，主线程不会等他执行完毕。
 */
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {

		try {
			int cnt = 0;
			while (true) {
				if (cnt++ > 10 && Thread.currentThread().getName().equals("simple_thread_0"))
					break;

				TimeUnit.MILLISECONDS.sleep(100);
				G.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			G.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws Exception {

		// 1、这个是thinking in java上的经典例子
		// for (int i = 0; i < 10; i++) {
		// Thread daemon = new Thread(new SimpleDaemons());
		// daemon.setDaemon(true); // Must call before start()
		// daemon.start();
		// }

		// 2、自己设想一个例子，两个线程，一个是Damon thread，另一个 simple thread。如果simple thread
		// 运行没有结束，那么damon thread也会一直运行下去。如果当simple thread停止运行，那么damon
		// thread也会停止运行，整个程序结束。
		Thread t1 = new Thread(new SimpleDaemons(), "damon_thread_0");
		t1.setDaemon(true);
		Thread t2 = new Thread(new SimpleDaemons(), "simple_thread_0");

		t1.start();
		t2.start();
		G.println("All daemons started");
		// 总的来说，主线程执行结束后，Damon Thread也就自然消失了。
		// TimeUnit.MILLISECONDS.sleep(100);
	}

}
