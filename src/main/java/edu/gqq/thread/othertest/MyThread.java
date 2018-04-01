package edu.gqq.thread.othertest;

import edu.gqq.common.GqqBase;

class MyRunnable implements Runnable {

	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("MyRunnable running");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class MyThread extends GqqBase {
	public static void main(String[] args) {
		// 1、这个例子诠释了run和start的区别，run表示的依然是单线程，但是start是新开始一个线程
		println("1、这个例子诠释了run和start的区别，run表示的依然是单线程，但是start是新开始一个线程");
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		t.start();
		// mr.run();
		System.out.println("end!");

		// 2、thread name test
		println();
		println("2、thread name test");
		System.out.println(Thread.currentThread().getName());

		int i = 0;
		// hey may not execute sequentially, meaning thread 1 may not be the
		// first thread to write its name to System.out. This is because the
		// threads are in principle executing in parallel and not sequentially.
		while (i++ < 5) {
			new Thread("thread_" + i) {
				public void run() {
					System.out.println("current thread is:" + getName());
				};
			}.start();
		}
	}
}
