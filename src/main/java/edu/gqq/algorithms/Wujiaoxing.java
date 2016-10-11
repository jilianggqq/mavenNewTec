package edu.gqq.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

public class Wujiaoxing {
	public List<List<Integer>> getPailie(List<Integer> nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.size() == 1) {
			List<Integer> one = new ArrayList<>(nums);
			res.add(one);
			return res;
		}

		for (int i = 0; i < nums.size(); i++) {
			List<Integer> subnums = new ArrayList<>(nums);
			subnums.remove(i);
			List<List<Integer>> subRes = getPailie(subnums);
			for (List<Integer> list : subRes) {
				List<Integer> newlist = new ArrayList<>();
				newlist.add(nums.get(i));
				newlist.addAll(list);
				res.add(newlist);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Wujiaoxing wujiaoxing = new Wujiaoxing();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<List<Integer>> pailie = wujiaoxing.getPailie(list);

		for (List<Integer> list2 : pailie) {
			Integer[] arr = list2.toArray(new Integer[list2.size()]);
			int a1 = arr[0] + arr[2] + arr[5] + arr[8];
			int a2 = arr[0] + arr[3] + arr[6] + arr[9];
			int a3 = arr[1] + arr[2] + arr[3] + arr[4];
			int a4 = arr[1] + arr[5] + arr[7] + arr[9];
			int a5 = arr[4] + arr[6] + arr[7] + arr[8];

			if (a1 == a2 && a1 == a3 && a4 == a5 && a5 == a1) {
				out.println(list2);
			}
		}

		out.println(pailie.size());
		// out.println(pailie);
	}
}
