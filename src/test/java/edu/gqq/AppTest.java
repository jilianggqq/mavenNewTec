package edu.gqq;

import org.apache.log4j.Logger;

import edu.gqq.util.Log4jUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	Logger logger = Logger.getLogger(AppTest.class);

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue("abc" == "abc");
		logger.debug("test App success");
		System.out.println("abc".substring(0,2));
		System.out.println("test App success2");
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp2() {
		String a = new String("abc");
		String b = "abc";
		assertTrue(a.equals(b));
	}
}
