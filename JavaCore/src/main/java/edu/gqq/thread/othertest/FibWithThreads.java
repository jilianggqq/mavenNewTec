package edu.gqq.thread.othertest;

import java.util.concurrent.Callable;

public class FibWithThreads implements Callable<Integer> {

	private int n;

	public FibWithThreads(int n) {
		this.n = n;
	}

	@Override
	public Integer call() throws Exception {
		if (n == 0 || n == 1) {
			return 1;
		}

		int num = n;
		int before = 1;
		int after = 1;
		for (int i = 2; i <= num; i++) {
			int temp = after;
			after = before + after;
			before = temp;
		}
		return after;
	}

}
