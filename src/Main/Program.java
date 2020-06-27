package Main;

import Exceptions.indexAlreadyTakenException;
import beans.Player;
import beans.Ship;
import inputCheck.Checks;

public class Program {

	public static void main(String[] args) throws indexAlreadyTakenException {
		
//		Print p = new Print();
//		p.printEmptyBoard();
		
		Ship s = new Ship(5, true);
		Ship s2 = new Ship(5, false);

		Player p1 = new Player();
		try {
			p1.placeShip(5, 1, s);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int[][] b = p1.getBoard();
//		p1.printBoard();
		Checks check = new Checks();
//		System.out.println(check.checkInputForInt(8));
//		System.out.println(check.checkInputForChar('6'));
		

			try {
				p1.placeShip(2, 3, s2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p1.printBoard();
		
		
	}

}
