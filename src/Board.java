
public class Board {

	// method to show the board
	public static void showBoard(char[][] brd) {
		int numRow = brd.length;
		int numCol = brd[0].length;

		System.out.println();

		// First write the column header
		System.out.print("    ");
		for (int i = 0; i < numCol; i++)
			System.out.print(i + "   ");
		System.out.print('\n');

		System.out.println(); // blank line after the header

		// The write the table
		for (int i = 0; i < numRow; i++) {
			System.out.print(i + "  ");
			for (int j = 0; j < numCol; j++) {
				if (j != 0)
					System.out.print("|");
				System.out.print(" " + brd[i][j] + " ");
			}

			System.out.println();

			if (i != (numRow - 1)) {
				// separator line
				System.out.print("   ");
				for (int j = 0; j < numCol; j++) {
					if (j != 0)
						System.out.print("+");
					System.out.print("---");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
// method to reset the board
	public static void resetBoard(char[][] brd) {
		for (int i = 0; i < brd.length; i++)
			for (int j = 0; j < brd[0].length; j++)
				brd[i][j] = ' ';
	}
}
