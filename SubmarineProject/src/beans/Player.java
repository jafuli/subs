package beans;

import java.util.ArrayList;
import java.util.List;

import inputCheck.Checks;

public class Player {

	private int[][] playerBoard = new int[10][10];
	private int[][] guessBoard = new int[10][10];
	private List<Ship> playerShips = new ArrayList<Ship>();
	private List<Ship> enemyShips = new ArrayList<Ship>();
	private boolean winner = false;

	private Checks check = new Checks();

	public Player() {
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
				if (ship.getVisibleId() == o) {
					System.out.println("hit");
					ship.setHitsCounter();
					if (winCheck())
						winner = true;
					else
						System.out.println("no win");
					return true;
				}
			}
		} else {
			System.out.println("miss");
		}
		return false;
	}
	
	public boolean winCheck() {
		for (Ship ship : enemyShips) {
			if (!ship.isSunk()) {
				return false;
			}
		}
		return true;
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



	public int[][] getGuessBoard() {
		return guessBoard;
	}

}
