package edu.gqq.thread.joining;

import java.util.concurrent.TimeUnit;

import edu.gqq.common.G;

public class TestJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread joinThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.MILLISECONDS.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("this is thread infomation!");
			}
		});

		// 特别注意，joinThread必须先start，这样join方法才有作用。
		// 如果没有start的话，join方法是没有用的。
		joinThread.start();
		// 特别注意，join方法不会自动运行。但是主线程要等着子线程执行完才可以。
		joinThread.join();
		G.println("this is main info");
	}
}
