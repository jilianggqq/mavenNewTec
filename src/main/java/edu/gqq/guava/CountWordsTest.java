package edu.gqq.guava;

import java.util.Arrays;

import edu.gqq.generic.Out;
import static java.lang.System.out;

public class CountWordsTest {
	public static void main(String[] args) {
		String[] strings = {"aa", "aa","aa","bb"};
		long count = Arrays.stream(strings).filter(x->x.equals("aa")).count();
		out.println(count);
		count = Arrays.stream(strings).filter(x->x.equals("bb")).count();
		out.println(count);
	}
}
