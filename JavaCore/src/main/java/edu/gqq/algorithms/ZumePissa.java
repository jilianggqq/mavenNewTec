package edu.gqq.algorithms;

import java.util.Arrays;

public class ZumePissa {

	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int findIslands(int[][] board) {
		if (board == null || board.length == 0) {
			return 0;
		}
		int m = board.length, n = board[0].length;
		int sum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					dfs(board, i, j, m, n);
					sum++;
				}
			}
		}
		return sum;
	}

	public static void dfs(int[][] board, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 1)
			return;
		board[i][j] = 2;
		for (int[] dir : dirs) {
			dfs(board, i + dir[0], j + dir[1], m, n);
		}
	}
	
	public static void findRect(int[][] board, int[] lefttop, int[] rightbottom) {
		if (board == null || board.length == 0) {
			return;
		}
		int m = board.length, n = board[0].length;
		boolean isFind = findLefttop(board, lefttop);
		if (!isFind) {
			return;
		}
		
		int bottom = lefttop[0];
		while (bottom < m && board[bottom][lefttop[1]] == 0) bottom++;
		bottom--;
		
		int right = lefttop[1];
		while (right < n && board[lefttop[0]][right] == 0) right++;
		right--;
		
		rightbottom[0] = bottom;
		rightbottom[1] = right;
	}
	
	

	private static boolean findLefttop(int[][] board, int[] lefttop) {
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					lefttop[0] = i;
					lefttop[1] = j;
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
//		int[][] image3 = {
//				  {1, 1, 1, 1, 1, 1, 1},
//				  {1, 0, 0, 0, 0, 1, 1},
//				  {1, 0, 0, 1, 0, 1, 1},
//				  {1, 1, 1, 1, 1, 1, 1},
//				  {1, 1, 0, 1, 1, 1, 1},
//				  {1, 1, 1, 0, 0, 1, 1},
//				  {1, 1, 1, 0, 0, 1, 1},
//				  {1, 1, 1, 1, 1, 1, 1},
//				};
//		
//		System.out.println(findIslands(image3));
		
		int[][] image1 = {
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				  {1, 1, 1, 0, 0, 1, 1},
				  {1, 1, 1, 0, 0, 1, 1},
				  {1, 1, 1, 1, 1, 1, 1},
				};
		
		int[] lefttop = {-1, -1};
		int[] rightbottom = {-1, -1};
		findRect(image1, lefttop, rightbottom);
		
		System.out.println(Arrays.toString(lefttop));
		System.out.println(Arrays.toString(rightbottom));
	}
}
