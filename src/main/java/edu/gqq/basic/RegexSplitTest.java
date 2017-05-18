package edu.gqq.basic;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RegexSplitTest {
	@Test
	public void testSplit() throws Exception {
		String string = "first     middle  last";
		String[] splits = string.split("\\s+");
		for (String str : splits) {
			System.out.println(str);
		}
		// Arrays.as
		System.out.println("****************");
		// but if the string contains "\", is it ok?
		String str = "first     middle  \\last";
		String[] strs = str.split("\\s+");
		for (String s : strs) {
			System.out.println(s);
		}
	}
}
