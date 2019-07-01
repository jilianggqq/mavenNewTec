package edu.gqq.thread.othertest;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class LiftOffTest {

	public static void main(String[] args) {
		// NewFixedThreadPool();
		// NewSingleThreadExecutor();
		// TestCallable();

		testLambdaRunnable();
		outputInfos();
	}

	private static void outputInfos() {
		System.out.println("Threading Finished!");
	}

	private static void testLambdaRunnable() {
		new Thread(() -> {
			System.out.println("just a test");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("just a test2");
		}).start();
	}

	public static void NewThread() {
		// Thread thread = new Thread(new LiftOff());
		// thread.start();

		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for lift off!");
	}

	public static void NewCachedThreadPool() {
		ExecutorService exec = Executors.newCachedThreadPool();
		System.out.println("Waiting for lift off!");

		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		// 产生异常，在shutdown之后
		// exec.execute(new LiftOff());
		// 还是会继续往下执行
		System.out.println("Waiting for lift off2!");

	}

	public static void NewFixedThreadPool() {
		// newFixedThreadPool中的参数表示最多有多少个线程在排队
		ExecutorService exec = Executors.newFixedThreadPool(2);
		System.out.println("Waiting for lift off!");

		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		// 产生异常，在shutdown之后
		// exec.execute(new LiftOff());
		// 还是会继续往下执行
		System.out.println("Waiting for lift off2!");

	}

	public static void NewSingleThreadExecutor() {
		// 类似于newFixedThreadPool(1)，一个线程中最多只能放一个线程。
		ExecutorService exec = Executors.newSingleThreadExecutor();
		System.out.println("Waiting for lift off!");

		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		// 产生异常，在shutdown之后
		// exec.execute(new LiftOff());
		// 还是会继续往下执行
		System.out.println("Waiting for lift off2!");

	}

	public static void TestCallable() {
		ExecutorService exec = Executors.newCachedThreadPool();
		// ArrayList<Future<Integer>> lstFutures = new ArrayList<>();

		Future<Integer> future = exec.submit(new FibWithThreads(10));

		System.out.println("Fibtest Ok 2");
		try {
			// get方法开始等待，一直等到返回值。
			Integer res = future.get();
			System.out.println("result is " + res);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Fibtest Ok ");

	}
}
