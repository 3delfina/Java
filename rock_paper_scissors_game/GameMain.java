/**
 * Marija Mumm, 2232817m
 * Main method for Rock-Paper-Scissors-Lizard-Spock game.
 *
 * JP2 Laboratory 7 2017.
 */

package game;

import java.util.Scanner;

public class GameMain {

	/**
	 * Prompts the user for the tournament parameters and then runs a tournament.
	 */
	public static void main(String[] args) {
		// Read everything from standard input
		Scanner stdin = new Scanner(System.in);

		// First player is always a computer
		GamePlayer player1 = new ComputerPlayer("Computer");

		// Second player may be a computer or a human
		GamePlayer player2;
		System.out.println("Enter name of human player, or empty string for two computer players");
		String name = stdin.nextLine();
		if (name.length() == 0) {
			System.out.println("Using two computer players");
			player2 = new ComputerPlayer("Computer2");
		} else {
			player2 = new HumanPlayer(name, stdin);
		}

		// Get the number of games required to win the tournament -- and be sure
		// it is a positive integer
		int numGames = -1;
		while (numGames <= 0) {
			System.out.println("Enter number of games to win: ");
			try {
				numGames = stdin.nextInt();
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
			if (numGames <= 0) {
				System.out.println("Invalid input!");
			}
		}

		// Run the tournament with the given parameters
		GamePlayer winner = playTournament(player1, player2, numGames);

		System.out.println("------------------");
		System.out.println("Overall winner is: " + winner.getName());

		stdin.close();
	}

	// simulate a tournament between the two players until one player has won
	// numGames times
	// return the winner
	private static GamePlayer playTournament(GamePlayer player1, GamePlayer player2, int numGames) {
		int win1 = 0; // how many times player1 won
		int win2 = 0; // how many times player2 won
		GamePlayer winner = null;
		while (win1 != numGames && win2 != numGames) {
			Symbol s1 = player1.chooseSymbol();
			System.out.println("Player one chose " + s1);
			Symbol s2 = player2.chooseSymbol();
			System.out.println("Player two chose " + s2);
			// call the addHistory method on both players
			player1.addHistory(s1, s2);
			player2.addHistory(s2, s1);
			GameResult r = s1.getResult(s2);
			if (r.equals(GameResult.WIN)) {
				win1++;
				System.out.println("This time player one wins!");
			} else if (r.equals(GameResult.LOSE)) {
				win2++;
				System.out.println("This time player two wins!");
			} else {
				System.out.println("Draw!");
			}
		}
		if (win1 == numGames) {
			System.out.println("The winner of the tournament is... player one!");
			winner = player1;
		} else {
			System.out.println("The winner of the tournament is... player two!");
			winner = player2;
		}

		return winner;
	}
}
