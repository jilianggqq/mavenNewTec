package edu.gqq.thread.coding_variations;

import java.util.concurrent.TimeUnit;

/**
 * 线程变量<br>
 * 
 * @author gqq<br>
 *         必须养成良好的注释习惯，这样下次看代码就不会那么痛苦
 */
public class ThreadVariations {
	public static void main(String[] args) {
		// 1、2、3分别测试separate method、anonymous Thread、anonymous Runnable
		new ThreadMethod("ThreadMethod_1").runTask();
		new ThreadMethod("ThreadMethod_2").runTask();

		new InnerRunnable2("InnerRunnable2");

		new InnerThread2("InnerThread2");

		// 4、测试匿名接口的实现方法
		// iTest test = new iTest() {
		//
		// @Override
		// public void test() {
		// System.out.println("test 匿名接口");
		// }
		// };
		// test.test();

		// 5、测试匿名类的重写方法。
		// annoymousTest aTest = new annoymousTest() {
		// @Override
		// public void printInfo() {
		// System.out.println("this is overrited");
		// }
		// };
		// aTest.printInfo();
	}
}

interface iTest {
	void test();
}

class annoymousTest {
	public void printInfo() {
		System.out.println("this is unoverrited");
	}
}

/**
 * 使用一个匿名的thread对象，这个对象是直接继承自Thread这个方法的
 * 
 * @author gqq
 *
 */
class InnerThread2 {
	private int countDown = 5;

	public InnerThread2(String string) {
		Thread t = new Thread(string) {
			@Override
			public String toString() {
				// 由于这个匿名的Thread类是继承自Thread类的，所以可以直接调用Thread类的方法，如getName
				return getName() + ":" + countDown;
			}

			@Override
			public void run() {
				while (true) {
					try {
						System.out.println(this);
						if (countDown-- <= 0)
							return;
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}

}

/**
 * 使用Runnable启用一个新的线程
 * 
 * @author gqq
 *
 */
class InnerRunnable2 {

	private int countDown = 5;

	public InnerRunnable2(String name) {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						System.out.println(this);
						if (countDown-- <= 0)
							return;
						TimeUnit.MILLISECONDS.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			@Override
			public String toString() {
				// 这个匿名类是实现Runnable接口的，所以没有getName方法。
				return Thread.currentThread().getName() + ":" + countDown;
			}
		}, name).start();
	}
}

/**
 * A separate method to run some code as a task:<br>
 * 使用独立的方法启动一个新的线程
 * 
 * @author gqq
 *
 */
class ThreadMethod {
	String name;

	// GqqBase b = new GqqBase();

	private int countDown = 5;
	Thread t;

	public ThreadMethod(String name) {
		this.name = name;
	}

	public void runTask() {
		// 这是匿名类的一种写法，就是将实现的代码写在new class的后面
		t = new Thread(name) {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println(Thread.currentThread().getName());
						if (countDown-- <= 0)
							return;
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
}
