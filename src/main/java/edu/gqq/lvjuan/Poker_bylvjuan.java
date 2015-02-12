package edu.gqq.lvjuan;

import java.util.Arrays;
import java.util.Scanner;

public class Poker_bylvjuan {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner in = new Scanner(System.in);
		int res = -10;
		String str1 = "";
		String str2 = "";
		try {
			str1 = in.nextLine();
			str2 = in.nextLine();
		} catch (Exception e) {
			str1 = null;
		}
		
		str1 = str1.replaceAll(",", "");
		str2 = str2.replaceAll(",", "");
		/*System.out.println(str1);
		System.out.println(str2);*/
		int[] p1s = toints(str1);
		int[] p2s = toints(str2);
		
		Arrays.sort(p1s);
		Arrays.sort(p2s);
		print(p1s);
		print(p2s);
		
		int rank1 = getRank(p1s);
		int rank2 = getRank(p2s);
		
		/*System.out.println(rank1);
		System.out.println(rank2);*/
		if(rank1 > rank2)
			res = 1;
		else if(rank1 < rank2)
			res = -1;
		else {
			if(rank1 == 5 || rank1 == 4) {
				if(p1s[3] > p2s[3])
					res = 1;
				else if(p1s[3] == p2s[3])
					res = 0;
				else
					res = -1;
			}
			if(rank1 == 3) {
				int same1, same2, sing1, sing2;
				if(p1s[0] != p1s[1]) {
					sing1 = p1s[0];
					same1 = p1s[1];
				}else {
					sing1 = p1s[3];
					same1 = p1s[2];
				}
				if(p2s[0] != p2s[1]) {
					sing2 = p2s[0];
					same2 = p2s[1];
				}else {
					sing2 = p2s[3];
					same2 = p2s[2];
				}
				if((same1 > same2) || (same1 == same2 && sing1 > sing2))
					res = 1;
				else if((same1 < same2) || (same1 == same2 && sing1 < sing2))
					res = -1;
				else
					res = 0;
					
			}
			if(rank1 == 2) {
				int high1, high2, low1, low2, sig1, sig2;
				if(p1s[0] == p1s[1] && p1s[2] == p1s[3]) {
					high1 = p1s[2];
					low1 = p1s[0];
					high2 = p2s[2];
					low2 = p2s[0];
					if(high1 > high2)
						res = 1;
					else if (high1 < high2)
						res = -1;
					else if(low1 > low2)
						res = 1;
					else if(low1 < low2)
						res = -1;
					else
						res = 0;
					
					if(high1 > high2)
						res = 1;
					else if(high1 < high2)
						res = -1;
					else {
						if(low1 > low2)
							res = 1;
						else if(low1 < low2)
							res = -1;
						else
							res = 0;
					}
				}else {
					if(p1s[0] == p1s[1]) {
						high1 = p1s[0];
						low1 = p1s[3];
						sig1 = p1s[2];
					} else if (p1s[1] == p1s[2]) {
						high1 = p1s[1];
						low1 = p1s[3];
						sig1 = p1s[0];
					}else {
						high1 = p1s[2];
						low1 = p1s[1];
						sig1 = p1s[0];
					}
					
					if(p2s[0] == p2s[1]) {
						high2 = p2s[0];
						low2 = p2s[3];
						sig2 = p2s[2];
					} else if (p2s[1] == p2s[2]) {
						high2 = p2s[1];
						low2 = p2s[3];
						sig2 = p2s[0];
					}else {
						high2 = p2s[2];
						low2 = p2s[1];
						sig2 = p2s[0];
					}
					
					if(high1 > high2)
						res = 1;
					else if(high1 < high2)
						res = -1;
					else {
						if(low1 > low2)
							res = 1;
						else if(low1 < low2)
							res = -1;
						else {
							if(sig1 > sig2)
								res = 1;
							else if(sig1 < sig2)
								res = -1;
							else
								res = 0;
						}
					}
				}
				if (p1s[0] == p1s[1] && p1s[2] == p1s[3] && ((p2s[1] == p2s[2]) || p2s[0] != p2s[1] || 
						p2s[2] != p2s[3])) {
					res = 1;
				}
				if (p2s[0] == p2s[1] && p2s[2] == p2s[3] && ((p1s[1] == p1s[2]) || p1s[0] != p1s[1] ||
						p1s[2] != p1s[3])) {
					res = -1;
				}
				
			}
			
			if(rank1 == 1) {
				int k = p1s.length - 1;
				boolean flag = false;
				while(k >= 0) {
					if(p1s[k] > p2s[k]) {
						res = 1;
						flag = true;
						break;
					}else if (p1s[k] < p2s[k]) {
						res = -1;
						flag = true;
						break;
					}else {
//						System.out.println(p1s[k] + " " + p2s[k]);
						k--;
						continue;
					}
				}
				if(!flag)
					res = 0;
			}
			
		}
		System.out.println(res);
	}

	private static int[] toints(String str1) {
		int[] ints = { 0, 0, 0, 0 };
		char[] chs = str1.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if ('J' == chs[i])
				ints[i] = 11;
			else if ('Q' == chs[i])
				ints[i] = 12;
			else if ('K' == chs[i])
				ints[i] = 13;
			else if ('A' == chs[i])
				ints[i] = 14;
			else {
				ints[i] = Integer.parseInt(chs[i] + "");
			}
		}
		return ints;
//		int rank1 = getRank(ints);
	}

	private static int getRank(int[] ints) {
		Arrays.sort(ints);
//		_quickSort(ints, 0, ints.length - 1);
		int rank = 0;
		if (ints[0] == ints[1] && ints[2] == ints[1] && ints[2] == ints[3])
			rank = 5;
		else if (ints[0] + 1 == ints[1] && ints[2] == ints[1] + 1 && ints[2] + 1 == ints[3]) {
			rank = 4;
		} else if ((ints[0] == ints[1] && ints[2] == ints[1]) || (ints[1] == ints[2] && ints[2] == ints[3])) {
			rank = 3;
		}else if (ints[0] == ints[1] || ints[1] == ints[2] || ints[2] == ints[3]) {
			rank = 2;
		}else {
			rank = 1;
		}
		return rank;
	}
	
	public static void print(int[] a) {
		int len = a.length;
		for(int i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	/*public static void _quickSort(Integer[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public static int getMiddle(Integer[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}*/
}
