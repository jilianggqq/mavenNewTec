/**
 * 
 */
package edu.gqq.thread;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

/**
 * @author gqq
 *
 */
public class ThreadTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 这个需要特别注意，JUnit的垃圾回收机制是不一样的。<br>
	 * 因此，不等到所有的线程执行完，就会退出这个主程序，这个和Main还是不一样的。<br>
	 * 因此，使用单元测试来测试多线程是不是有待改进呢
	 */
	@Test
	public void NewThread() {
		// Thread thread = new Thread(new LiftOff());
		// thread.start();

		// for (int i = 0; i < 5; i++) {
		// new Thread(new LiftOff()).start();
		// }
		// System.out.println("Waiting for lift off!");
	}

	@Test
	public void NewCachedThreadPool() {
		// ExecutorService exec = Executors.newCachedThreadPool();
		// for (int i = 0; i < 5; i++) {
		// exec.execute(new LiftOff());
		// }
		// exec.shutdown();
	}

	@Test
	public void TestFib() {

		int num = 11;
		int before = 1;
		int after = 1;
		for (int i = 2; i <= num; i++) {
			int temp = after;
			after = before + after;
			before = temp;
		}

		System.out.print(before);
		assertEquals(55 + 89, after);
	}

}

