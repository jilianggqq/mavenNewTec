package edu.gqq.future;

import java.security.Timestamp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class TraditionalFuture {
	private static final int NUMBER_OF_THREADS = 10;

	public static void futureExample() {
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

		Callable<String> asyncTask = new Callable<String>() {
			@Override
			public String call() throws Exception {
				out.println(Thread.currentThread().getName() + " asyncTask");
				return computeResult();
			}

		};

		Callable<String> asyncTask2 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				out.println(Thread.currentThread().getName() + " asyncTask2");
				TimeUnit.SECONDS.sleep(6);
				return computeResult2();
			}

			private String computeResult2() {
				return "computeResult2";
			}

		};

		Future<String> future = executor.submit(asyncTask);
		Future<String> future2 = executor.submit(asyncTask2);

		try {
			String result2 = future2.get();
			useResult(result2);

		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			String result = future.get();
			useResult(result);
		} catch (ExecutionException e) {
			e.printStackTrace();
			// log.error("Task failed", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// log.warn("Task interrupted", e);
		}
		doSomethingElse();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		out.println("will shutdown");
		executor.shutdown();
	}

	private static void useResult(String result) {
		// TODO Auto-generated method stub
		out.format("The result is %s.\n", result);
	}

	private static void doSomethingElse() {
		// TODO Auto-generated method stub
		out.println("do something else");
	}

	private static String computeResult() {
		// TODO Auto-generated method stub
		return "this is a test string";
	}

	public static void main(String[] args) {
		futureExample();
	}
}
