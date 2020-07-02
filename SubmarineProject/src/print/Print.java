package print;

public class Print {

	public static void printEmptyBoard() {
		System.out.println("A  B  C  D  E  F  G  H  I  J");
		System.out.println("____________________________");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(0 + "  ");
			}
			System.out.println("| " + i);
		}
	}
	
}
