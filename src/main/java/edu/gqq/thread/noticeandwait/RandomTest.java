package edu.gqq.thread.noticeandwait;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import edu.gqq.common.RandomUtil;

class ModifyList {
	ArrayList<Integer> arrs = new ArrayList<Integer>();

	public synchronized void add(int e) {
		arrs.add(e);
	}

	public synchronized void print() {
		arrs.forEach(x -> out.println(x));
	}
}

class Process extends Thread {
	ModifyList m;
	int value;

	public Process(ModifyList m, int val) {
		this.m = m;
		value = val;
	}
	@Override
	public void run() {
		out.println("start to process...");
		// Arrays.asList(5, 7, 8, 2).forEach(x -> out.print(x + " "));
		m.add(value);
		out.println("process ok...");
	}
}

public class RandomTest extends Thread {
	ModifyList m = new ModifyList();
	@Override
	public void run() {
		while (true) {
			// type type = (type) en.nextElement();
			int randInt = RandomUtil.randInt(1, 10);

			if (randInt <= 7) {
				out.println(getName() + "---" + randInt + " start to process");
				try {
					// TimeUnit.SECONDS.sleep(1);
					Process p = new Process(m, randInt);
					p.start();
					// p.join();
					out.println("process end, " + getName() + " invoked");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				out.println(getName() + "---" + randInt + " will sleep 10s\n");
				try {
					TimeUnit.SECONDS.sleep(5);
					m.print();
					out.println("sleep end, " + getName() + " invoked");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new RandomTest().start();
	}
}
