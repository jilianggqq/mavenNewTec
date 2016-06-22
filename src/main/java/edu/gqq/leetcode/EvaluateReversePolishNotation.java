package edu.gqq.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] arrs = { "4", "13", "5", "/", "+" };
		out.println(evalRPN(arrs));
	}

	@Test
	public void testHashSet(){
		HashSet<Integer> ss = new HashSet<>();
		ss.add(3);
		ss.add(4);
//		ss.re
		String s="";
		s.toCharArray();
	}
	
	public static int evalRPN(String[] tokens) {
		String[] nts = { "+", "-", "*", "/" };
		HashSet<String> notations = new HashSet<>(Arrays.asList(nts));
		// List<String> stacks = new ArrayList<>();
		Stack<String> stacks = new Stack<>();

		Arrays.stream(tokens).forEach(s -> {
			if (notations.contains(s)) {
				// Integer first = Integer.valueOf(stacks.pop());
				char xx = stacks.pop().charAt(0);
				int first = (int) (xx - '0');
				// Integer second = Integer.valueOf(stacks.pop());
				int second = (int) (stacks.pop().charAt(0) - '0');
				int value = 0;
				switch (s) {
				case "+":
					value = first + second;
					break;
				case "-":
					value = second - first;

					break;
				case "*":
					value = second * first;
					break;
				case "/":
					value = second / first;
					break;
				}
				stacks.push(String.valueOf(value));
			} else {
				stacks.push(s);
			}
		});
		return Integer.valueOf(stacks.pop());
	}
}
