package edu.gqq.lvjuan;

public class MaxString {
	public static void main(String[] args) {
		int result = getMax();
		
		System.out.println("the result is:" + result);
	}

	private static int getMax() {
		// System.out.println("test");
		String text = "acaccbavbb";
		String query = "vbbc";
		int max = 0;
		int qlen = query.length();
		int len = text.length();
		for (int i = 0; i < len - 1; i++) {
			int position = i + qlen - len;
			if (position <= 0) {
				int res = queryMax(query, text.substring(i, i + qlen));
				max = res > max ? res : max;
			} else if (position > max) {
				for (int j = 0; j < qlen + i - len; j++) {
					String tmp = text.substring(j, j + qlen);
					int res = queryMax(tmp,
 query.substring(j, tmp.length()));
					max = res > max ? res : max;
				}
			}
		}
		return max;
	}

	private static int queryMax(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int max = 0;
		int temp = 0;
		for (int i = 0; i < c2.length; i++) {
			if (c1[i] == c2[i])
				temp++;
			else {
				max = temp > max ? temp : max;
				temp = 0;
			}
		}
		max = temp > max ? temp : max;
		return max;
	}
}
