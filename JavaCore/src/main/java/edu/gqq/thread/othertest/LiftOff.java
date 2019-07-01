package edu.gqq.thread.othertest;

public class LiftOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;

	// 这个很好的诠释了如何生成一个唯一Id
	private final int id = taskCount++;

	private String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + ")";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		// Thread t = new Thread(new LiftOff());
		// t.start();
		// Thread t1 = new Thread(new LiftOff());
		// t1.start();

		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}

		System.out.println("Waiting for lift off!");
	}

}
