package edu.gqq.future;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import javax.security.auth.callback.Callback;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import static java.lang.System.out;

public class AsListTest {
	private static ListeningExecutorService executorService;

	public static void main(String[] args) {
		executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
		
		ListenableFuture<Integer> result1 = execute1();
		ListenableFuture<Integer> result2 = execute2();
		ListenableFuture<Integer> result3 = execute3();

		// 如果用successfulAsList，出现异常就会返回null，其余的继续执行。
		ListenableFuture<List<Integer>> successfulAsList = Futures.successfulAsList(result1, result2, result3);

		// 如果用到allaslist，如果抛出异常，则后面的不会往下执行。
		// ListenableFuture<List<Integer>> successfulAsList =
		// Futures.allAsList(result1, result2, result3);

		Futures.addCallback(successfulAsList, new FutureCallback<List<Integer>>() {

			@Override
			public void onSuccess(List<Integer> result) {
				// TODO Auto-generated method stub
				out.println(result);
			}

			@Override
			public void onFailure(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
				// out.println(t.getMessage());
			}

		});
		// try {
		// List<Integer> list = successfulAsList.get();
		// out.println(list.size());
		// for (Integer integer : list) {
		// out.println(integer);
		// }
		//
		// } catch (InterruptedException | ExecutionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		executorService.shutdown();
	}

	public static ListenableFuture<Integer> execute1() {
		return executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return Integer.valueOf("aaa");
			}
		});
	}

	public static ListenableFuture<Integer> execute2() {
		return executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return Integer.valueOf("2");
			}
		});
	}

	public static ListenableFuture<Integer> execute3() {
		return executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return Integer.valueOf("-1");
			}
		});
	}

	// public static ListenableFuture<String> execute2() {
	// return executorService.submit(new Callable<String>() {
	//
	// @Override
	// public String call() throws Exception {
	// return "2";
	// }
	// });
	// }
	//
	// public static ListenableFuture<String> execute3() {
	// return executorService.submit(new Callable<String>() {
	//
	// @Override
	// public String call() throws Exception {
	// return "-1";
	// }
	// });
	// }
}
