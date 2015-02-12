package edu.gqq.common;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBeforeDay() {
		String string = DateUtils.getBeforeDay(5, "MM-dd");
		System.out.println(string);
	}

}
