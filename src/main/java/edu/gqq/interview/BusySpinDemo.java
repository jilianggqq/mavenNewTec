package edu.gqq.interview;

import java.util.ArrayList;
import java.util.List;

public class BusySpinDemo {

	public static void main(String[] args) {
		ProdThread pt = new ProdThread();
		Thread t1 = new Thread(pt, "Producer");
		// passing producer thread in consumer thread
		Thread t2 = new Thread(new ConThread(pt), "Consumer");
		t1.start();
		t2.start();
	}
}

// Producer thread
class ProdThread implements Runnable {
	List<Integer> sharedListObj;
	boolean flag;

	ProdThread() {
		System.out.println("Constructor ProdThread");
		this.sharedListObj = new ArrayList<Integer>();
		this.flag = true;
	}

	@Override
	public void run() {
		System.out.println(" ProdThread run");
		for (int i = 0; i < 5; i++) {
			System.out.println("Adding to queue - " + Thread.currentThread().getName() + " " + i);
			sharedListObj.add(i);
		}
		flag = false;
	}
}

// Consumer thread
class ConThread implements Runnable {
	ProdThread pt;

	ConThread(ProdThread pt) {
		System.out.println("Constructor ConThread");
		this.pt = pt;
	}

	@Override
	public void run() {
		// Busy spinning loop
		while (this.pt.flag) {
			System.out.println("Waiting busy spinning");
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("Consumer starting");
		for (Integer i : this.pt.sharedListObj) {
			System.out.println("" + i);
		}
	}
}