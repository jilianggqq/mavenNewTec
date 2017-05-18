package edu.gqq.thread.noticeandwait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import edu.gqq.common.Log4jUtil;
import edu.gqq.common.RandomUtil;

class ModifyList {
	static Logger logger = Log4jUtil.getLogger(ModifyList.class);
	ArrayList<Integer> arrs = new ArrayList<Integer>();

	public synchronized void add(int e) {
		if (arrs.size() >= 10)
			arrs.clear();
		arrs.add(e);
	}

	public synchronized void print() {
		arrs.forEach(x -> logger.debug(x));
	}
}

class Process extends Thread {
	static Logger logger = Log4jUtil.getLogger(Process.class);
	ModifyList m;
	int value;

	public Process(ModifyList m, int val) {
		this.m = m;
		value = val;
	}
	@Override
	public void run() {
		logger.debug("start to process...");
		// Arrays.asList(5, 7, 8, 2).forEach(x -> out.print(x + " "));
		m.add(value);
		logger.debug("process ok...");
	}
}

public class RandomTest extends Thread {
	static Logger logger = Log4jUtil.getLogger(RandomTest.class);
	ModifyList m = new ModifyList();
	@Override
	public void run() {
		while (true) {
			// type type = (type) en.nextElement();
			int randInt = RandomUtil.randInt(1, 10);

			if (randInt <= 7) {
				logger.debug(getName() + "---" + randInt + " start to process");
				try {
					// TimeUnit.SECONDS.sleep(1);
					Process p = new Process(m, randInt);
					p.start();
					// p.join();
					logger.debug("process end, " + getName() + " invoked");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				logger.debug(getName() + "---" + randInt + " will sleep 10s\n");
				try {
					TimeUnit.SECONDS.sleep(5);
					m.print();
					logger.debug("sleep end, " + getName() + " invoked");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		logger.debug("starting...");
		new RandomTest().start();
	}
}
