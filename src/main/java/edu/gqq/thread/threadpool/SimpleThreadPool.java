package edu.gqq.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		// 这句话的意思特别像thread.join
		// join的意思是让本线程等其它线程执行完。
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

}