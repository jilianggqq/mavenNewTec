package edu.gqq.algorithms;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import static java.lang.System.out;

public class DecodeString {
	public String decodeString(String s) {
		String pattern = "(\\d+?)\\[(\\w+?)\\]";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(s);

		out.println(s);
		if (m.find()) {
			int start = m.start();
			int end = m.end();
			int times = Integer.valueOf(m.group(1));
			String val = m.group(2);
			String res = "";
			for (int i = 0; i < times; i++) {
				res += val;
			}

			return decodeString(s.substring(0, start) + res + s.substring(end));
		}

		return s;
	}

	@Test
	public void testDecodeString() throws Exception {
		assertEquals("abc", decodeString("abc"));
		assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
		assertEquals("accaccacc", decodeString("3[a2[c]]"));
		assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
	}
}
