package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int level = 0;
		getResult(result, new ArrayList<Integer>(), candidates, target, 0, level);

		return result;
	}

	private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start, int level) {
		String prefix = "";
		for (int i = 0; i < level; i++) {
			prefix += "----";
		}

		if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				if (target >= candidates[i]) {					
					out.println(prefix + String.format("target:%s, candidates[%d]:%d, start:%d", target, i, candidates[i], start));
					cur.add(candidates[i]);
					printList(cur, level);
					getResult(result, cur, candidates, target - candidates[i], i, level + 1);
					printList(cur, level);
					cur.remove(cur.size() - 1);
				} else {
					out.println(prefix + String.format("too large target:%s, candidates[%d]:%d, start:%d", target, i, candidates[i], start));
				}
			} // for
		} // if
		else if (target == 0) {
			out.println(prefix + ":target is 0");
			printList(cur, level);
			result.add(new ArrayList<Integer>(cur));
		} // else if
	}

	private void printList(List<Integer> lst, int level) {
		String prefix = "";
		for (int i = 0; i < level; i++) {
			prefix += "----";
		}
		out.print(prefix);
		lst.forEach(x -> out.print(x + "  "));
		out.println();
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		 int[] candidates = { 2, 4 };
//		int[] candidates = { 4,8 };
		List<List<Integer>> combinationSum = cs.combinationSum(candidates, 8);
		out.println(combinationSum);
	}
}
