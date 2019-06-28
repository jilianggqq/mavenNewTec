package edu.gqq.thread.joining;

import edu.gqq.common.G;

class Info {
	public static int value = 0;
}

class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}

	public void run() {
		try {
			G.println(getName() + " will sleep about " + duration + " millseconds");
			sleep(duration);
			Info.value = 3;
		} catch (InterruptedException e) {
			G.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		G.println(getName() + " has awakened");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}

	public void run() {
		try {
			// 开始的时候，Info的value为0，sleeper可以修改这个变量
			G.println("old value is:" + Info.value);
			// 在这里要等到sleeper完成之后，才继续往下执行
			sleeper.join();
		} catch (InterruptedException e) {
			G.println("Interrupted");
		}
		G.println("current value is:" + Info.value);
		G.println(getName() + " join completed");
	}
}

public class Joining {
	public static void main(String[] args) {
		// 1、经典例子
		Sleeper sleepy = new Sleeper("Sleepy", 1500), grumpy = new Sleeper("Grumpy", 2500);
		Joiner dopey = new Joiner("Dopey", sleepy), doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();

		// 2、用一个线程去修改一个变量，另一个线程去读取这个变量（灵活的思维在于创造）
		// Sleeper sleeper = new Sleeper("Sleeper", 300);
		// Joiner joiner = new Joiner("Joiner", sleeper);
		// sleeper.start();
	}
}