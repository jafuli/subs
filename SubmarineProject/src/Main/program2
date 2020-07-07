package Main;

import java.util.Scanner;

import Exceptions.invalidShotException;
import beans.Player;
import beans.Ship;
import inputCheck.Checks;

public class Program2 {

	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();

//		System.out.print("Player 1, ");
//		p1.fill();
//		System.out.print("Player 2, ");
//		p2.fill();

		try {
			generateBoard(p1);
			generateBoard(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p1.setGuessBoard(p2.getPlayerBoard());
		p2.setGuessBoard(p1.getPlayerBoard());
		p1.setEnemyShips(p2.getPlayerShips());
		p2.setEnemyShips(p1.getPlayerShips());

		Scanner sc = new Scanner(System.in);

		boolean p1Turn = true;
		while (!p1.isWinner() && !p2.isWinner()) {
			if (p1Turn) {
				System.out.println("player 1 - player board:");
				p1.printPlayerBoard();
				System.out.println("player 1 - guess board:");
				p1.printGuessBoard();
				System.out.println("Player 1, shoot: ");
				System.out.print("row: ");
				String indexR1 = sc.next();
				if (!Checks.checkInputForInt(indexR1)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				System.out.print("column: ");
				String indexC1 = sc.next();
				if (!Checks.checkInputForInt(indexC1)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				try {
					int indexR = Integer.parseInt(indexR1);
					int indexC = Integer.parseInt(indexC1);
					p1.shoot(indexR, indexC);
				} catch (invalidShotException e) {
					System.out.println(e.getMessage() + ", try again");
					continue;
				}
				p1Turn = false;
			} else {
				System.out.println("player 2 - player board:");
				p2.printPlayerBoard();
				System.out.println("player 2 - guess board:");
				p2.printGuessBoard();
				System.out.println("Player 2, shoot:");
				System.out.print("row: ");
				String indexR1 = sc.next();
				if (!Checks.checkInputForInt(indexR1)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				System.out.print("column: ");
				String indexC1 = sc.next();
				if (!Checks.checkInputForInt(indexC1)) {
					System.out.println("Incorrect index, try again");
					continue;
				}
				try {
					int indexR = Integer.parseInt(indexR1);
					int indexC = Integer.parseInt(indexC1);
					p2.shoot(indexR, indexC);
				} catch (invalidShotException e) {
					System.out.println(e.getMessage() + ", try again");
					continue;
				}
				p1Turn = true;
			}
		}
		if (p1.isWinner())
			System.out.println("Player 1 is the winner");
		else
			System.out.println("Player 2 is the winner");
	}
	
	public static void generateBoard(Player p) throws Exception {
		int[] shipSizes = { 2, 2, 3, 4, 5 };
		for (int i = 0; i < shipSizes.length; i++) {
			Ship s = new Ship(shipSizes[i], false);
			p.placeShip(i, i, s);
			p.getPlayerShips().add(s);
		}
	}

}
