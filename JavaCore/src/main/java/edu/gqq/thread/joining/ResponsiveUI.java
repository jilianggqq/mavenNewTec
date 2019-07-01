package edu.gqq.thread.joining;

import java.util.concurrent.TimeUnit;

import edu.gqq.common.G;

//: concurrency/ResponsiveUI.java 
//User interface responsiveness. 
//{RunByHand} 
class UnresponsiveUI {
	private volatile double d = 1;

	public UnresponsiveUI() throws Exception {
		while (d > 0)
			d = d + (Math.PI + Math.E) / d;
		System.in.read(); // Never gets here
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		// 这句非常重要，不然，主线程永远不会停止的
		setDaemon(true);
		start();
	}

	public void run() {
		while (true) {
			// d = d + (Math.PI + Math.E) / d;
			d = d + 2;
			System.out.println(d);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// ! new UnresponsiveUI(); // Must kill this process
		new ResponsiveUI();
		System.in.read();
		System.out.println(d); // Shows progress
	}
}