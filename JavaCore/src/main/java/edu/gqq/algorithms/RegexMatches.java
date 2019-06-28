package edu.gqq.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class RegexMatches {

	public static void main(String args[]) {
		// String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String line2 = "ab32[2[ab]c]ef32[23[cd]c]";
		String pattern = "(.*)(\\d+)(.*)";
		String pattern2 = "(\\d+?)\\[(\\w+?)\\]";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		Pattern r2 = Pattern.compile(pattern2);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		Matcher m2 = r2.matcher(line2);
		out.println(m.groupCount());

		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
		} else {
			System.out.println("NO MATCH");
		}

		out.println(m2.groupCount());
		// if (m2.find()) {
		// System.out.println("Found value: " + m2.group(0));
		// System.out.println("Found value: " + m2.group(1));
		// System.out.println("Found value: " + m2.group(2));
		// } else {
		// System.out.println("NO MATCH");
		// }
		int count = 0;
		while (m2.find()) {
			count++;
			System.out.println("Match number " + count);
			System.out.println("start(): " + m2.start());
			System.out.println("end(): " + m2.end());
			System.out.println("Found value: " + m2.group(1));
			System.out.println("Found value: " + m2.group(2));
		}
		
		out.println(line2.substring(5, 10));
	}
}