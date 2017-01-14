package edu.gqq.basic;

import static java.lang.System.out;

public class StringOperation {
	public static void main(String[] args) {
		String str = "leetleetleet";
		out.println(str.indexOf("leet2", 1)); // -1
		out.println(str.indexOf("leet", 0)); // 0
		out.println(str.indexOf("leet", 1)); // 4
	}
}
