package edu.gqq.leetcode;

import static java.lang.System.out;

//1702766719
//2126753390
public class VersionControl {
	public int firstBadVersion(int n) {
		return check(1, n);
	}

	public int check(int start, int end) {
		int mid = (start + end) / 2;
		// 1. mid is good version.
		while (!(isBadVersion(mid) && (mid == 1 || !isBadVersion(mid - 1)))) {
			if (!isBadVersion(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		return mid;
		// if (isBadVersion(mid) && (mid == 1 || !isBadVersion(mid - 1))) {
		// return mid;
		// } else if (isBadVersion(mid)) {
		// return check(start, mid - 1);
		// } else {
		// return check(mid + 1, end);
		// }
	}

	private boolean isBadVersion(int mid) {
		return mid >= 170276671;
	}

	public static void main(String[] args) {
		VersionControl v = new VersionControl();
		int fv = v.firstBadVersion(212675339);
		out.println(fv);

	}
}
