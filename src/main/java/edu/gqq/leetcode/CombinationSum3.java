package edu.gqq.leetcode;

import static java.lang.System.out;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.sun.crypto.provider.ARCFOURCipher;
import com.sun.org.apache.regexp.internal.recompile;

public class CombinationSum3 {
	@Test
	public void testHashSet() {

		HashSet<ArrayList<Integer>> hshArrInt = new HashSet<>();
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();

		a1.add(3);
		a1.add(4);
		a1.add(5);
		a1.add(6);

		a2.add(3);
		a2.add(4);
		a2.add(5);
		a2.add(6);
		hshArrInt.add(a1);
		hshArrInt.add(a2);
		assertTrue(hshArrInt.size() == 1);

		// for (ArrayList<Integer> list : hshArrInt) {
		// list.forEach(x -> out.println(x + "\t"));
		// out.println();
		// }

	}

	@Test
	public void testIntergerHashSet() {
		HashSet<Integer> hstIntTest = new HashSet<>();
		hstIntTest.add(1);
		hstIntTest.add(2);
		hstIntTest.add(2);
		assertTrue(hstIntTest.size() == 2);
	}

	@Test
	public void testCovertToHashlist() {
		HashSet<ArrayList<Integer>> hshArrInt = new HashSet<>();
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();

		a1.add(3);
		a1.add(4);
		a1.add(5);
		a1.add(6);

		a2.add(3);
		a2.add(4);
		a2.add(5);
		a2.add(6);
		hshArrInt.add(a1);
		hshArrInt.add(a2);
		assertTrue(hshArrInt.size() == 1);

		ArrayList<ArrayList<Integer>> lstIn = new ArrayList<>(hshArrInt);
		assertEquals(1, lstIn.size());
		// lstIn.forEach(x -> out.println(x + " "));
	}

	@Test
	public void testCombinationSum32() {
		List<List<Integer>> combinationSum32 = combinationSum32(9, 45);
		combinationSum32.forEach(x -> out.println(Arrays.toString(x.toArray())));
		
		out.println(",B,c".split(",").length);
	}

	public static List<List<Integer>> combinationSum32(int k, int n) {
		return com(1, k, n);
	}

	private static List<List<Integer>> com(int m, int k, int n) {
		List<List<Integer>> arrs = new ArrayList<>();
		if (k == 0 || m > n / k) {
			return arrs;
		}

		if (k == 1 && n >= 1 && n <= 9) {
			List<Integer> one = new ArrayList<>();
			one.add(n);
			arrs.add(one);
			return arrs;
		}
		List<List<Integer>> containsm = com(m + 1, k - 1, n - m);
		List<List<Integer>> discontainsm = com(m + 1, k, n);
		containsm.forEach(x -> x.add(m));
		arrs.addAll(containsm);
		arrs.addAll(discontainsm);
		return arrs;
	}

	@Test
	public void testCombination() {
		List<List<Integer>> list = combinationSum3(8, 40);
		out.println("size is " + list.size());
		list.forEach(l -> {
			l.forEach(x -> {
				out.print(x + "  ");
			});
			out.println();
		});
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinationSumTwoLength = combinationSum3fun(k, n);
		List<List<Integer>> result = new ArrayList<>();
		// combinationSumTwoLength.stream().filter(x -> x.stream().filter(y -> y <= 9));
		combinationSumTwoLength.forEach(x -> {
			boolean anyMatch = x.stream().anyMatch(y -> y > 9);
			if (!anyMatch) {
				result.add(x);
			}
		});
		return result;
	}

	public static List<List<Integer>> combinationSum3fun(int k, int n) {
		if (n > 45) {
			return new ArrayList<>();
		}
		if (k == 1) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			if (n >= 1 && n <= 9) {
				list.add(n);
			}
			result.add(list);
			return result;
		}

		HashSet<List<Integer>> hssResult = new HashSet<>();
		if (2 == k) {
			List<List<Integer>> combinationSumTwoLength = combinationSumTwoLength(n);
			return combinationSumTwoLength;
		}

		List<List<Integer>> lastResult = combinationSum3fun(k - 1, n);

		// every number can divided into a numberSet
		HashSet<HashSet<Integer>> numberResult = new HashSet<>();
		HashSet<HashSet<Integer>> finalSet = new HashSet<>();
		for (List<Integer> intList : lastResult) {
			for (Integer number : intList) {
				List<List<Integer>> twoNumberResult = combinationSumTwoLength(number);
				for (List<Integer> list : twoNumberResult) {
					HashSet<Integer> numberOneSet = new HashSet<>(intList);
					numberOneSet.remove(number);
					numberOneSet.addAll(list);
					if (numberOneSet.size() == k) {
						numberResult.add(numberOneSet);
					}
				}
			}
			finalSet.addAll(numberResult);
		}

		for (HashSet<Integer> hashSet : finalSet) {
			hssResult.add(new ArrayList<>(hashSet));
		}

		return new ArrayList<>(hssResult);
	}

	public static List<List<Integer>> combinationSumTwoLength(int n) {
		List<List<Integer>> lstResult = new ArrayList<>();
		for (int i = 1; i <= n / 2; i++) {
			HashSet<Integer> hst = new HashSet<>();
			// if (n - i < 10) {
			hst.add(i);
			hst.add(n - i);
			// }
			if (hst.size() == 2) {
				List<Integer> lstR = new ArrayList<>(hst);
				lstResult.add(lstR);
			}
		}
		return lstResult;
	}
}
