package edu.gqq.thread.resource;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	/**
	 * 如果多线程操作时，肯定会出现错误 线程1执行了第一行，线程2执行了第一行，<br>
	 * 线程1又执行了第二行，然后返回，则可能出现奇数<br>
	 * 如果加了synchronized关键词，就不会出现这种情况了
	 */
	public synchronized int next() {
		++currentEvenValue; // Danger point here!
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}