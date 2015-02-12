package edu.gqq.thread;

import edu.gqq.common.GqqBase;

/**
 * 竞争条件和临界区的测试
 * 
 * @author gqq
 *
 */
public class Counter extends GqqBase {

	protected long count = 0;

	public void add(long value) {
		this.count = this.count + value;
		println(Thread.currentThread().getName() + ":" + count);
	}

	public static void main(String[] args) {
		Counter ct = new Counter();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// try {
				// // 加了这句之后，可以让t2延时运行
				// Thread.sleep(1000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				ct.add(3);
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ct.add(2);
			}
		}, "t2");
		t1.start();
		t2.start();
		// println(ct.count);
	}
}
