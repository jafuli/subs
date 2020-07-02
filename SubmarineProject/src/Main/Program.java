package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.indexAlreadyTakenException;
import beans.Player;
import beans.Ship;
import inputCheck.Checks;

public class Program {

	public static void main(String[] args) throws indexAlreadyTakenException {

//		Print p = new Print();
//		p.printEmptyBoard();

//		for (int i = 0; i < shipSizes.length; i++) {
//			ships.add(new Ship(shipSizes[i], true));
//		}
//		System.out.println(ships);

//		Ship s = new Ship(3, true);
//		Ship s2 = new Ship(5, false);

		int[] shipSizes = { 2, 2, 3, 4, 5 };
		Player p1 = new Player();
		Player p2 = new Player();
//		try {
//			p1.placeShip(5, 1, s);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//		int[][] b = p1.getBoard();
//		p1.printBoard();
//		Checks check = new Checks();
//		System.out.println(check.checkInputForInt(8));
//		System.out.println(check.checkInputForChar('6'));

//		try {
//			p1.placeShip(2, 3, s2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		p1.printBoard();

//		List<Ship> ships = new ArrayList<Ship>();

//		System.out.println("place 5 ships:");
//		Scanner sc = new Scanner(System.in);
//		int i = 0;
//		while (i < shipSizes.length) {
//			try {
//				System.out.println("Ship no." + (i + 1) + " - ship length: " + shipSizes[i]);
//				System.out.print("row coordinates:");
//				int row = sc.nextInt();
//				System.out.print("column coordinates:");
//				int column = sc.nextInt();
//				System.out.print("ship horizontal? ");
//				boolean horizontal = sc.nextBoolean();
////				ships.add(new Ship(shipSizes[i], horizontal));
//				p1.placeShip(row, column, new Ship(shipSizes[i], horizontal));
//				i++;
//			} catch (Exception e) {
//				// add input check for all chars in this method
//				System.out.println(e.getMessage());
//				System.out.println("place again please: ");
//			}
//		}
		
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
		
		p1.shoot(0, 0);
		p1.shoot(1, 0);
//		p1.getEnemyShips();
//		System.out.println(ships);
		p1.printBoard();
		System.out.println();
		p2.printBoard();

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
