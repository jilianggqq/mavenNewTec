package edu.gqq.design.chess;

/**
 * enumaration
 * @author itu
 *
 */
public enum ChessCell {
	Null('+'), Player1Cell('O'), Player2Cell('X');
	private char cell;

	ChessCell(char cell) {
		this.cell = cell;
	}

	public char getCell() {
		return cell;
	}
}
