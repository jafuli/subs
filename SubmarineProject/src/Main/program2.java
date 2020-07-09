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

		System.out.print("Player 1, ");
		p1.fill(); // player 1 creates his board
		System.out.print("Player 2, ");
		p2.fill(); // player 2 creates his board
		
		
		p1.setGuessBoard(p2.getPlayerBoard());
		p2.setGuessBoard(p1.getPlayerBoard());
		p1.setEnemyShips(p2.getPlayerShips());
		p2.setEnemyShips(p1.getPlayerShips());

		Scanner sc = new Scanner(System.in);

		boolean p1Turn = true; 
		while (!p1.isWinner() && !p2.isWinner()) { // game runs until all enemy ships are sunk and a winner is found 
			if (p1Turn) { // checking player 1 turn input
				System.out.println("player 1 - player board:");
				p1.printPlayerBoard(); // show own board
				System.out.println("player 1 - guess board:");
				p1.printGuessBoard(); // show enemy board
				System.out.println("Player 1, shoot: ");
				System.out.print("row: "); // insert coordinates for shot
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
				p1Turn = false; // player 1 turn ends, player 2 turn starts
			} else {
				System.out.println("player 2 - player board:"); // checking player 2 turn input
				p2.printPlayerBoard(); // show own board
				System.out.println("player 2 - guess board:");
				p2.printGuessBoard();// show enemy board
				System.out.println("Player 2, shoot:");
				System.out.print("row: "); // insert coordinates for shot
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
				p1Turn = true; // player 2 turn ends, player 1 turn starts
			}
		}
		if (p1.isWinner()) // print who wins
			System.out.println("Player 1 is the win...\nBIBI wins, we all lose!");
		else
			System.out.println("Player 2 is the win...\nBIBI wins, we all lose!");
		
		sc.close();
	}
	

}
