package edu.gqq;

import org.apache.log4j.Logger;

import edu.gqq.common.Log4jUtil;
import edu.gqq.guava.MutliMapTest;

/**
 * Hello world!
 *
 */
public class App {
	static Logger logger = Log4jUtil.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("this is logger info");
		System.out.println("Hello World!");
		// test guava
		MutliMapTest.doMain();
	}
}
