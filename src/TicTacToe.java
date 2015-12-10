import java.util.Scanner;
import java.io.*;

public class TicTacToe {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		final int SIZE = 3;
		char[][] board = new char[SIZE][SIZE]; // game board
		String cont = "y";
		int wins = 0;
		int losses = 0;
		int tie = 0;

		do {
			// initialize the board (with ' ' for all cells)
			Board.resetBoard(board);
			// initialize number of moves
			int moves = 0;

			// First, welcome message and display the board.
			System.out.println("===== WELCOME TO THE TIC-TAC-TOE GAME!! =====\n");
			Board.showBoard(board);

			// Then ask the user which symbol (x or o) he/she wants to play.
			System.out.print("  Which symbol do you want to play, \"x\" or \"o\"? ");
			char userSymbol = sc.next().toLowerCase().charAt(0);

			// validates player choice, can only be x or o
			userSymbol = Validator.validatePlayerChoice(sc, userSymbol);

			char compSymbol = (userSymbol == 'x') ? 'o' : 'x';

			// Also ask whether or not the user wants to go first.
			System.out.println();
			System.out.print("  Do you want to go first (y/n)? ");
			char ans = sc.next().toLowerCase().charAt(0);

			// validates the user input, can't put numbers in
			ans = Validator.validatePlayerTurn(sc, ans);

			int turn; // 0 -- the user, 1 -- the computer
			int remainCount = SIZE * SIZE; // empty cell count

			// THE VERY FIRST MOVE.
			if (ans == 'y') {
				turn = 0;
				GamePlay.userPlay(board, userSymbol); // user puts his/her first
														// tic
				moves = 1;
			} else {
				turn = 1;
				GamePlay.compPlay(board, compSymbol);// computer puts its first
														// tic
			}

			// Show the board, and decrement the count of remaining cells.
			Board.showBoard(board);
			remainCount--;

			// Play the game until either one wins.
			boolean done = false;
			int winner = 0; // 0 -- the user, 1 -- the computer, -1 -- draw

			while (!done && remainCount > 0) {
				// If there is a winner at this time, set the winner and the
				// done flag to true.
				done = GamePlay.isGameWon(board, turn, userSymbol, compSymbol);
				// Did the turn win?

				if (done)
					winner = turn; // the one who made the last move won the
									// game
				else {
					// No winner yet. Find the next turn and play.
					turn = (turn + 1) % 2;

					if (turn == 0) {
						GamePlay.userPlay(board, userSymbol);
						moves++; // move counter for end output
					} else
						GamePlay.compPlay(board, compSymbol);

					// Show the board after one tic, and decrement the rem
					// count.
					Board.showBoard(board);
					remainCount--;
				}
			}

			// Winner is found. Declare the winner.
			if (winner == 0) {
				Music.musicApplause();
				System.out.println("\n** YOU WON.  CONGRATULATIONS!! **");
				System.out.println("It took you " + moves + " moves! ");
				wins++; // counter for number of wins
			} else if (winner == 1) {
				Music.musicBoo();
				System.out.println("\n** YOU LOST..  How the heck did you lose!? **");
				losses++; // counter for number of losses
			} else {
				System.out.println("\n** DRAW... **");
				tie++; // counter for number of draws
			}

			System.out.println("Would you like to play again? (y/n): ");
			cont = sc.next();
			// validates user input for playing again
			// (can only enter y or n)
			cont = Validator.validateContinue(sc, cont);
		} while (cont.equalsIgnoreCase("y"));

		System.out.println(" You won " + wins + " games! \n You lost " + losses + " games! \n You tied " + tie
				+ " games. \n Thanks for playing.");
	}

}