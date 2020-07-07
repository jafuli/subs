package inputCheck;

import Exceptions.indexAlreadyTakenException;
import beans.Player;
import beans.Ship;

public class Checks {

	public static boolean checkInputForInt(String input) {
		if (input.length() == 1) {
			for (int i = 0; i < 10; i++) {
				try {
					if (Integer.parseInt(input) == i)
						return true;
				} catch (NumberFormatException e) {
					return false;
				}
			}
		}
		return false;
	}

	public static boolean checkInputForChar(char input) {
		char inp = Character.toUpperCase(input);
		for (int i = 65; i < 75; i++) {
			if ((int) inp == i)
				return true;
		}
		return false;
	}

	public void checkShipPlacement(Player player, int indexR, int indexC, Ship ship) throws indexAlreadyTakenException {
		int[][] testBoard = new int[10][10];
		for (int i = 0; i < testBoard.length; i++) {
			for (int j = 0; j < testBoard.length; j++) {
				testBoard[i][j] = player.getPlayerBoard()[i][j];
			}
		}
		if (ship.isHorizontal()) {
			for (int i = 0; i < ship.getLength(); indexC++, i++) {
				if (testBoard[indexR][indexC] > 0) {
					throw new indexAlreadyTakenException();
				} else {
					try {
						testBoard[indexR][indexC] = 1;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("index out of bounds");
					}
				}
			}
		} else {
			for (int i = 0; i < ship.getLength(); indexR++, i++) {
				if (testBoard[indexR][indexC] > 0) {
					throw new indexAlreadyTakenException();
				} else {
					try {
						testBoard[indexR][indexC] = 1;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("index out of bounds");
					}

				}
			}
		}
	}

}
