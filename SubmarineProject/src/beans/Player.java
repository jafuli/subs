package beans;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Exceptions.invalidShotException;
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
	
	// inputs is designed for 1 char only
	public void fill() {
		int[] shipSizes = { 2, 2, 3, 4, 5 };
		System.out.println("place 5 ships:");
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i < shipSizes.length) {
			try {
				System.out.println("Ship no." + (i + 1) + " - ship length: " + shipSizes[i]);
				System.out.print("row coordinates (0-9): ");
				String row = sc.next();
				if (!Checks.checkInputForInt(row)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				System.out.print("column coordinates (0-9): ");
				String column = sc.next();
				if (!Checks.checkInputForInt(column)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				System.out.println("ship horizontal?\n1> Yes\n2> No ");
				Boolean horizontal;
				int isHorizontal = sc.nextInt();
				if (isHorizontal == 1)
					horizontal = true;
				else if (isHorizontal == 2)
					horizontal = false;
				else {
					System.out.println("Incorrect choice, try again");
					continue;
				}
				int row1 = Integer.parseInt(row);
				int column1 = Integer.parseInt(column);
				placeShip(row1, column1, new Ship(shipSizes[i], horizontal));
				i++;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect choice, try again");
				System.out.println("place again please: ");
			} catch (Exception e) {
				// add input check for all chars in this method
				System.out.println(e.getMessage());
				System.out.println("place again please: ");
			}
		}
//		sc.close();
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

	public void printPlayerBoard() {
		for (int i = 0; i < playerBoard.length; i++) {
			for (int j = 0; j < playerBoard[i].length; j++) {
//				System.out.print(playerBoard[i][j] + " "); // change to ships visual
				if (playerBoard[i][j] >= 0)
					System.out.print(playerBoard[i][j] + " ");
				else if (playerBoard[i][j] < 0 && playerBoard[i][j] >= -10)
					System.out.print("* ");
				else if (playerBoard[i][j] == -11)
					System.out.print("X ");
			}
			System.out.println();
		}
	}

	public void printGuessBoard() {
		for (int i = 0; i < guessBoard.length; i++) {
			for (int j = 0; j < guessBoard[i].length; j++) {
				if (guessBoard[i][j] >= 0) {
					System.out.print("0 ");
				} else if (guessBoard[i][j] < 0 && guessBoard[i][j] >= -10) {
					System.out.print("* ");
				} else if (guessBoard[i][j] == -11) {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

	// returns true if hit, false if miss, throws exception if shot to same place twice
	public boolean shoot(int indexR, int indexC) throws invalidShotException {
		if (guessBoard[indexR][indexC] < 0)
			throw new invalidShotException();
		int o = guessBoard[indexR][indexC];
		if (o > 0) { // ship undiscovered
			for (Ship ship : enemyShips) {
				if (ship.getVisibleId() == o) {
					System.out.println("hit");
					ship.setHitsCounter();
					if (winCheck())
						winner = true;
//					else
//						System.out.println("no win");
					guessBoard[indexR][indexC] = -1 * guessBoard[indexR][indexC]; // hit (-1 - -10)
					return true;
				}
			}
		}
		System.out.println("miss");
		guessBoard[indexR][indexC] = -11; // no hit
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

	public boolean isWinner() {
		return winner;
	}

}
