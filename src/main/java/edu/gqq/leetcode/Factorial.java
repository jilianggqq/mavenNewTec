package edu.gqq.leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import edu.gqq.common.G;

public class Factorial {

	public int getFactorial(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 1;
		}
		Map<Integer, Integer> results = new HashMap<>();
		results.put(1, 1);
		for (int i = 2; i <= n; i++) {
			results.put(i, results.get(i - 1) * i);
		}
		return results.get(n);
	}

	@Test
	public void testFactorial() throws Exception {
		assertEquals(6, getFactorial(3));
		G.println(getFactorial(5));
	}

	@Test
	public void testArrayListRemove() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		G.println(list.get(2));
		list.remove(2);
		G.println(list.get(2));
		list.remove(2);
		// IndexOutOfBoundsException
		// G.println(list.get(2));

	}
}
