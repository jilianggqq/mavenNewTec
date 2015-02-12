package edu.gqq.lvjuan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class IntCmp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 == o2 ? 0 : (o1 < o2 ? 1 : -1);
	}
}

public class Poker {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner in = new Scanner(System.in);
		String res;
		String str1;
		String str2;
		try {
			System.out.println("请输入四张牌，用逗号隔开！");
			System.out.println("请输入第一张牌");
			str1 = in.nextLine();
			System.out.println("请输入第二张牌");
			str2 = in.nextLine();
			int[] p1s = { 0, 0, 0, 0 };
			int[] p2s = { 0, 0, 0, 0 };

			int rank1 = getRank(p1s, str1);
			int rank2 = getRank(p2s, str2);

			int result = rank1 == rank2 ? getResult(p1s, p2s) : (rank1 > rank2 ? 1 : -1);
			if (result > 0) {
				System.out.print("第一张大");
			} else if (result < 0) {
				System.out.print("第二张大");
			} else {
				System.out.print("两张一样大");
			}
		} catch (Exception e) {
			str1 = null;
		}
	}

	/**
	 * 对于同一rank的牌，比较大小。
	 * 
	 * @param p1s
	 * @param p2s
	 * @return
	 */
	private static int getResult(int[] p1s, int[] p2s) {
		int res = 0;
		for (int i = 0; i < p1s.length; i++) {
			if (p1s[i] != p2s[i]) {
				res = p1s[i] > p2s[i] ? 1 : -1;
				break;
			}
		}
		return res;
	}

	public static int getRank(int[] outputs, String input) {
		Integer[] o1 = { 0, 0, 0, 0 };
		Integer[] o2 = { 0, 0, 0, 0 };
		char[] chs = input.replace(",", "").toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if ('J' == chs[i]) {
				o1[i] = 11;
				o2[i] = 11;

			} else if ('Q' == chs[i]) {
				o1[i] = 12;
				o2[i] = 12;
			} else if ('K' == chs[i]) {
				o1[i] = 13;
				o2[i] = 13;
			} else if ('A' == chs[i]) {
				// 这两个次序不能颠倒，如果颠倒了，在同一个Rank比较会出问题
				o1[i] = 14;
				o2[i] = 1;
			} else {
				o1[i] = Integer.parseInt(chs[i] + "");
				o2[i] = Integer.parseInt(chs[i] + "");
			}
		}

		// 首先获得o1的rank
		int rank1 = getRankValue(o1);
		int rank2 = getRankValue(o2);

		for (int i = 0; i < 4; i++) {
			outputs[i] = rank1 >= rank2 ? o1[i] : o2[i];
		}

		return rank1 >= rank2 ? rank1 : rank2;
	}

	public static int getRankValue(Integer[] vals) {
		int rank = 0;
		// 倒序排列
		Arrays.sort(vals, new IntCmp());
		if (vals[0] == vals[1] && vals[2] == vals[1] && vals[2] == vals[3])
			rank = 5;
		else if (vals[0] - 1 == vals[1] && vals[1] - 1 == vals[2] && vals[2] - 1 == vals[3]) {
			rank = 4;
		} else if (vals[0] == vals[1] && vals[1] == vals[2]) {
			rank = 3;
		} else if (vals[3] == vals[2] && vals[1] == vals[2]) {
			rank = 3;
			// 如果是后三个相同，重新按照升序排序，方便检查
			Arrays.sort(vals);
		} else if (vals[0] == vals[1] && vals[2] == vals[3]) {
			rank = 2;
		} else {
			rank = 1;
		}
		return rank;
	}


}
