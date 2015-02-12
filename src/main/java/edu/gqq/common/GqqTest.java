package edu.gqq.common;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class GqqTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("abc".indexOf("ab"), 0);
		assertEquals("abc".indexOf("bc", 1), 1);
		assertEquals("abc".indexOf("ac"), -1);
		// 返回第一次出现ab的位置
		assertEquals("abba".indexOf("ab", 0), 0);
	}

	@Test
	public void TestCountMatches() {
		// countMatch的思想就是先找出第一次匹配的索引，然后跳跃第二个字符串的长度，下一个匹配的索引。
		// 数目加一。
		int num = StringUtils.countMatches("abccabc", "abc");
		assertEquals(num, 2);
	}

}
