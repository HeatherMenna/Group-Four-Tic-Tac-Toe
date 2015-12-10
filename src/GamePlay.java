import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class GamePlay {
	
public static Scanner sc = new Scanner (System.in);

	public static void userPlay(char[][] brd, char usym) {
		System.out.print("\nEnter the row and column indices (press enter after each entry): ");
		String s = sc.nextLine(); // needed to read in string in case user tries to "break" program.
		
		int rowIndex = Validator.validateInteger(sc, s);
		//int rowIndex = sc.nextInt(); *****Removed to replace with Validator.validateInteger(sc, s) code
		rowIndex = Validator.validatePlayerRow(sc, rowIndex);
		int colIndex = Validator.validateInteger(sc, s);
		
		//int colIndex = sc.nextInt(); *****Removed to replace with Validator.validateInteger(sc, s) code
		colIndex = Validator.validatePlayerCol(sc, colIndex);

		while (brd[rowIndex][colIndex] != ' ') {
			System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
			rowIndex = sc.nextInt();
			rowIndex = Validator.validatePlayerRow(sc, rowIndex);
			colIndex = sc.nextInt();
			colIndex = Validator.validatePlayerCol(sc, colIndex);
		}

		brd[rowIndex][colIndex] = usym;
	}

	public static void compPlay(char[][] brd, char csym) {
		// Find the first empty cell and put a tic there.
		for (int i = 0; i < brd.length; i++) {
			for (int j = 0; j < brd[0].length; j++) {
				if (brd[i][j] == ' ') { // empty cell
					brd[i][j] = csym;
					return;
				}
			}
		}
	}

	public static boolean isGameWon(char[][] brd, int turn, char usym, char csym) {
		char sym;
		if (turn == 0)
			sym = usym;
		else
			sym = csym;

		int i, j;
		boolean win = false;

		// Check win by a row
		for (i = 0; i < brd.length && !win; i++) {
			for (j = 0; j < brd[0].length; j++) {
				if (brd[i][j] != sym)
					break;
			}
			if (j == brd[0].length)
				win = true;
		}

		// Check win by a column
		for (j = 0; j < brd[0].length && !win; j++) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][j] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Check win by a diagonal (1)
		if (!win) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][i] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Check win by a diagonal (2)
		if (!win) {
			for (i = 0; i < brd.length; i++) {
				if (brd[i][brd.length - 1 - i] != sym)
					break;
			}
			if (i == brd.length)
				win = true;
		}

		// Finally return win
		return win;
	}

}

