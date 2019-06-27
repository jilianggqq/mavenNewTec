package edu.gqq.leetcode;

import static java.lang.System.out;

public class GameOfLife {
	public static void gameOfLife(int[][] board) {
		if (board.length == 0) {
			return;
		}
		out.println(board[0].length);
		// out.println(board[1][2]);
		int[][] resultBoard = new int[board.length + 2][board[0].length + 2];
		for (int i = 1; i < resultBoard.length - 1; i++) {
			for (int j = 1; j < resultBoard[0].length - 1; j++) {
				// copy the value of board to the resultBoard.
				resultBoard[i][j] = board[i - 1][j - 1];
			}
		}
		// 2. processing the rules.
		for (int i = 1; i < resultBoard.length - 1; i++) {
			for (int j = 1; j < resultBoard[0].length - 1; j++) {
				// 1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
				// 2.Any live cell with two or three live neighbors lives on to the next generation.
				// 3.Any live cell with more than three live neighbors dies, as if by over-population..
				// 4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
				int liveCount = 0;
				for (int k = i - 1; k <= i + 1; k++) {
					for (int l = j - 1; l <= j + 1; l++) {
						liveCount += resultBoard[k][l] == 1 ? 1 : 0;
					}
				}
				if (resultBoard[i][j] == 1) {
					liveCount -= 1;
					if (liveCount < 2 || liveCount > 3) {
						board[i - 1][j - 1] = 0;
					}
				} else if (liveCount == 3) {
					board[i - 1][j - 1] = 1;
				}
			}
		}
		// 3. out put the result.
		output(board);
	}

	public static void gameOfLife2(int[][] board) {
		if (board.length == 0) {
			return;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int liveCount = getLivingCount(i, j, board);
				out.format("i:%d,j:%d,living Count:%d\n", i, j, liveCount);
				if (getCurrentRealValue(i, j, board) == 1) {
					if (liveCount < 2 || liveCount > 3) {
						board[i][j] = 2;
					}
				} else if (liveCount == 3) {
					board[i][j] = 3;
				}
			}
		}
		// set dieing(2) to 0 and live(3) to 1
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = (2 == board[i][j]) ? 0 : (3 == board[i][j] ? 1 : board[i][j]);
			}
		}
		// output the array.
		output(board);
	}

	/**
	 * get living number surrounding this cell. 
	 */
	public static int getLivingCount(int i, int j, int[][] board) {
		int sum = 0;
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				sum += getCurrentRealValue(k, l, board);
			}
		}
		return sum - getCurrentRealValue(i, j, board);
	}

	/**
	 * get the real value before game board changing.
	 * 
	 * @param i
	 *            line number
	 * @param j
	 *            column number
	 * @param board
	 *            the chess board.
	 * @return real number of before game board changed
	 */
	public static int getCurrentRealValue(int i, int j, int[][] board) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return 0;
		}
		// 2 means 1 to 0(die)
		if (2 == board[i][j])
			return 1;
		// 3 means 0 to 1(live)
		if (3 == board[i][j])
			return 0;
		return board[i][j];
	}

	public static void output(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				out.print(board[i][j] + "\t");
			}
			out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1 }, { 1, 0 } };
		// out.println(arr.length);
		gameOfLife2(arr);
	}
}
