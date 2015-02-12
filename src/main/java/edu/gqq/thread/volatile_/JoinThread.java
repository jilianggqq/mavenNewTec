package edu.gqq.thread.volatile_;

public class JoinThread extends Thread {
	public static int n = 0;

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				add();
				sleep(3); // 为了使运行结果更随机，延迟3毫秒

			} catch (Exception e) {
			}
	}

	/**
	 * 这里，static和非static的差距可大了<br>
	 * 如果没有static，每一个JoinThread对象都有一个add方法，所以在调用的时候，根本不会冲突。 <br>
	 * 因为每一个对象都copy了一份自己的
	 */
	public static synchronized void add() {
		n = n + 1;
	}

	public static void main(String[] args) throws Exception {

		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++)
			// 建立100个线程
			threads[i] = new JoinThread();
		for (int i = 0; i < threads.length; i++)
			// 运行刚才建立的100个线程
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100个线程都执行完后继续，直接调用join，让主线程等着子线程执行完

			threads[i].join();
		System.out.println(" n= " + JoinThread.n);
	}
}