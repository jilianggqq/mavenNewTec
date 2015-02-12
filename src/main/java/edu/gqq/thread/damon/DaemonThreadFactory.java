package edu.gqq.thread.damon;

import java.util.concurrent.ThreadFactory;

/**
 * 创造Damon thread的工厂
 * 
 * @author gqq
 *
 */
public class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
} // /:~