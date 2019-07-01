package edu.gqq.design.chess;

import java.util.Arrays;

public class ChessBoard {

	public static void main(String[] args) throws Exception {
		ChessBoard cb = new ChessBoard();
		cb.print();
		cb.add(1, 1);
		cb.print();
		cb.add(2, 1);
		// cb.add(2, 1);
		cb.print();
		cb.add(1, 2);
		cb.print();
		cb.add(2, 2);
		cb.print();
		cb.add(1, 3);
		cb.print();
		cb.add(2, 3);
		cb.print();
		cb.add(1, 4);
		cb.print();
		cb.add(2, 4);
		cb.print();
		System.out.println(cb.check(2, 4));
	}

	private Player player;
	private Status status;
	private char[][] board;
	private static final int LEN = 8;
	private final static int NOT_FINISHED = 0;
	private final static int PLAYER1_WIN = 1;
	private final static int PLAYER2_WIN = 2;
	private static final int WIN_LEN = 4;

	public ChessBoard() {
		board = new char[LEN][LEN];
		reset();
	}

	public void reset() {
		player = Player.Player1;
		status = Status.Running;
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				board[i][j] = ChessCell.Null.getCell();
			}
		}
	}

	/**
	 * @return 0 1 2
	 * @throws Exception
	 */
	public int add(int i, int j) throws Exception {
		if (i < 0 || i >= LEN || j < 0 || j >= LEN) {
			throw new Exception("boundary error");
		}
		if (status.equals(Status.Completed)) {
			throw new Exception("this round has completed");
		}
		if (board[i][j] != ChessCell.Null.getCell()) {
			throw new Exception("this cell is occupied");

		}
		if (player.equals(Player.Player1)) {
			board[i][j] = ChessCell.Player1Cell.getCell();
			player = Player.Player2;
			if (check(i, j)) {
				this.status = Status.Completed;
				return PLAYER1_WIN;
			}
		} else {
			board[i][j] = ChessCell.Player2Cell.getCell();
			player = Player.Player1;
			if (check(i, j)) {
				this.status = Status.Completed;
				return PLAYER2_WIN;
			}
		}
		return NOT_FINISHED;
	}

	private boolean check(int x, int y) {
		// check row
		int i = y, j = y;
		while (i >= 0 && board[x][i] == board[x][y])
			i--;
		while (j < LEN && board[x][j] == board[x][y])
			j++;
		if (j - i - 1 >= WIN_LEN)
			return true;
		return false;
	}

	public void print() {
		System.out.println(Arrays.deepToString(board));
	}
}
