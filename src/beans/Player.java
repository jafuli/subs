package beans;

import inputCheck.Checks;

public class Player {

	private int[][] board = new int[10][10];
	private Checks check = new Checks();

	public Player() {
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void placeShip(int indexR, int indexC, Ship ship) throws Exception {

		check.checkShipPlacement(this, indexR, indexC, ship);

		if (ship.isHorizontal()) {
			for (int i = 0; i < ship.getLength(); indexC++, i++) {
				board[indexR][indexC] = 1;
			}
		} else {
			for (int i = 0; i < ship.getLength(); indexR++, i++) {
				board[indexR][indexC] = 1;
			}
		}

	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
