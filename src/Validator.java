import java.util.Scanner;

public class Validator {
	// validates user input for continue options, can only select y or n
	public static String validateContinue(Scanner sc, String cont) {
		while (!cont.equalsIgnoreCase("y") && !cont.equalsIgnoreCase("n")) {
			System.out.println("That isn't a valid choice. Please enter \"y\" or \"n\" : ");
			cont = sc.next();
		}
		return cont;
	}
// validates the player choice for x or o
	public static char validatePlayerChoice(Scanner sc, char userSymbol) {
		while (!(userSymbol == ('x')) && !(userSymbol == ('o'))) {
			System.out.println("That isn't a valid choice. Please enter \"x\" or \"o\" : ");
			userSymbol = sc.next().toLowerCase().charAt(0);
		}
		return userSymbol;
	}
// validates the user input for first move
	public static char validatePlayerTurn(Scanner sc, char ans) {
		while (!(ans == ('y')) && !(ans == ('n'))) {
			System.out.println("That isn't a valid choice. Please enter \"y\" or \"n\" : ");
			ans = sc.next().toLowerCase().charAt(0);
		}
		return ans;
	}
	// validates the user input is an integer
	public static int validateInteger(Scanner sc, String s) {
		while (!sc.hasNextInt()) {
			System.out.println("!! Invalid input. Please enter a number: ");
	        s = sc.next();
	    }
	    return sc.nextInt();
		}
	
	public static int validatePlayerRow(Scanner sc, int rowIndex) {
		while (rowIndex < 0 || rowIndex > 2) {
			System.out.println("That isn't a valid row choice. Please enter a valid number between 0 - 2: ");
			rowIndex = sc.nextInt();
		}
		return rowIndex;
	}
	// validates the user input is between 0 & 2 for column
	public static int validatePlayerCol(Scanner sc, int colIndex) {
		while (colIndex < 0 || colIndex > 2) {
			System.out.println("That isn't a valid column choice. Please enter a valid number between 0 - 2:  ");
			colIndex = sc.nextInt();
		}
		return colIndex;
	}
}
