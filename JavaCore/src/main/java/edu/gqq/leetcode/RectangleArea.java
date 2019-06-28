package edu.gqq.leetcode;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		// 1 horizonal length |a-c|=u
		int u = Math.abs(A - C);
		// 1 vertical length |b-d|=v
		int v = Math.abs(B - D);
		// 2 horizonal length |g-e|=w
		int w = Math.abs(G - E);
		// 2 vertical length |h-f|=x
		int x = Math.abs(H - F);
		// common horizonal length = u + w - |max(g,c)-min(a,e)|
		int comWidth = u + w - Math.abs(Math.max(G, C) - Math.min(A, E));
		if (comWidth < 0) {
			comWidth = 0;
		}
		// common horizonal length = v + x - |max(d,h)-min(b,f)|
		int comHight = v + x - Math.abs(Math.max(D, H) - Math.min(B, F));
		if (comHight < 0) {
			comHight = 0;
		}
		return u * v + w * x - comHight * comWidth;
	}
}
