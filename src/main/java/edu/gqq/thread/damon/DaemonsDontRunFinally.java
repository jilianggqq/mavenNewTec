package edu.gqq.thread.damon;

import java.util.concurrent.TimeUnit;

import edu.gqq.common.GqqBase;

/**
 * 这个例子证明，finally里面的方法，有时候可以执行，有时候不会执行。
 * <p>
 * 如果不是daemon thread，那么一定会执行的。<br>
 * 这个和DaemonsDontRunFinally.main方法中sleep的时长有很大关系
 * 
 * @author gqq
 *
 */
class ADaemon extends GqqBase implements Runnable {
	public void run() {
		try {
			println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			println("Exiting via InterruptedException");
		} finally {
			println("This should always run?");
		}
	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
		TimeUnit.MILLISECONDS.sleep(1000);
	}
} /*
 * Output: Starting ADaemon
 */// :~ 