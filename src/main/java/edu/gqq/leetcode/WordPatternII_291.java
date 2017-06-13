package edu.gqq.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII_291 {
	public static void main(String[] args) {
		boolean res = wordPatternMatch("aba", "xyzxy");
		System.out.println(res);
	}

	public static boolean wordPatternMatch(String pattern, String str) {
		Map<String, Integer> strtochar = new HashMap<>();
		String[] chartostr = new String[128];
		return helper(0, str, pattern, strtochar, chartostr);
	}

	public static boolean helper(int idx, String str, String p, Map<String, Integer> strtochar, String[] chartostr) {
		if (idx == p.length() && str.length() == 0)
			return true;
		if (idx >= p.length() || str.length() == 0)
			return false;
		char c = p.charAt(idx);
		for (int i = 1; i <= str.length(); i++) {
			String sub = str.substring(0, i);
			boolean isadded = false;
			strtochar.forEach((k, v) -> {
				System.out.println(k + "->" + v);
			});
			if (!strtochar.containsKey(sub)) {
				if (chartostr[c] != null)
//					return false;
					continue;
				strtochar.put(sub, (int) c);
				chartostr[c] = sub;
				isadded = true;
			} else {
				isadded = false;
				if (strtochar.get(sub) != c)
//					return false;
					continue;
			}
			boolean res = helper(idx + 1, str.substring(i), p, strtochar, chartostr);
			if (res)
				return true;

			if (isadded) {
				strtochar.remove(sub);
				chartostr[c] = null;
			}
		}
		return false;
	}
}