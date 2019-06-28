package edu.gqq.thread.damon;

import java.lang.annotation.Retention;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




import edu.gqq.common.GqqBase;

public class DaemonFromFactory extends GqqBase implements Runnable {
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			println("Interrupted");
		}
	}

	public static void main(String[] args) throws Exception {
		// 1、这是Thinking in java上的标准程序。我们举一反三一下。
		// ExecutorService exec = Executors.newCachedThreadPool(new
		// DaemonThreadFactory());
		// for (int i = 0; i < 10; i++)
		// exec.execute(new DaemonFromFactory());
		// println("All daemons started");

		// 2、如何使用Lambda表达式来构造一个线程池。
		// 需要传递threadfactory接口，并且这个接口只有一个方法。传入参数为Runnalbe，返回为Thread
		// 通过这个例子，我也知道了java如何定义线程池
		ExecutorService exec2 = Executors.newCachedThreadPool(r -> {
			return new Thread(r);
		});

		ExecutorService exec3 = Executors.newCachedThreadPool(r -> {
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			return thread;
		});


		exec2.execute(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				println("Hello, I am in thread pool!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});

		// 这里有一个奇怪的问题，就是exec3不知道为什么，执行不会自动停止。实在令人郁闷
		exec3.execute(() -> {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
					println("Hello, I am in thread pool 3!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// TimeUnit.MILLISECONDS.sleep(900); // Run for a while
	}
} /* (Execute to see output) */// :~