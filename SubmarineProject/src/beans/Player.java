package beans;

import java.util.ArrayList;
import java.util.List;

import inputCheck.Checks;

public class Player {

	private int[][] playerBoard = new int[10][10];
	private int[][] guessBoard = new int[10][10];
	private List<Ship> playerShips = new ArrayList<Ship>();
	private List<Ship> enemyShips = new ArrayList<Ship>();

	private Checks check = new Checks();

	public Player() {
	}

	public int[][] getBoard() {
		return playerBoard;
	}

	public void setBoard(int[][] board) {
		this.playerBoard = board;
	}

	public void placeShip(int indexR, int indexC, Ship ship) throws Exception {

		check.checkShipPlacement(this, indexR, indexC, ship);

		if (ship.isHorizontal()) {
			for (int i = 0; i < ship.getLength(); indexC++, i++) {
				playerBoard[indexR][indexC] = ship.getId();
			}
		} else {
			for (int i = 0; i < ship.getLength(); indexR++, i++) {
				playerBoard[indexR][indexC] = ship.getId();
			}
		}

	}

	public void printBoard() {
		for (int i = 0; i < playerBoard.length; i++) {
			for (int j = 0; j < playerBoard[i].length; j++) {
				System.out.print(playerBoard[i][j]);
			}
			System.out.println();
		}
	}

	public boolean shoot(int indexR, int indexC) {
		int o = guessBoard[indexR][indexC];
		if (o > 0) {
			for (Ship ship : enemyShips) {
				if (ship.getId() == o) {
					System.out.println(ship.getHitsCounter());
					ship.setHitsCounter();
					System.out.println(ship.getHitsCounter());
					return true;
				}
			}
		}
		return false;
	}

	public int[][] getPlayerBoard() {
		return playerBoard;
	}

	public void setGuessBoard(int[][] guessBoard) {
		this.guessBoard = guessBoard;
	}

	public List<Ship> getPlayerShips() {
		return playerShips;
	}

	public void setPlayerShips(List<Ship> playerShips) {
		this.playerShips = playerShips;
	}

	public List<Ship> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(List<Ship> enemyShips) {
		this.enemyShips = enemyShips;
	}

}
