//Marija Mumm, 2232817m
package game;

import java.util.Scanner;

public class HumanPlayer extends GamePlayer {

	private Scanner scan;

	// constructor
	public HumanPlayer(String name, Scanner scan) {
		super(name);
		this.scan = scan;
	}

	//prompt the user to choose one of the five symbols
	//return an appropriate Symbol instance
	@Override
	public Symbol chooseSymbol() {
		Symbol chosenSymbol = null;
		System.out.println("Choose one of the five symbols: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");
		while (chosenSymbol == null) {
			try {
				String input = scan.nextLine();
				chosenSymbol = Symbol.valueOf(input);
			} catch (IllegalArgumentException ex) {
			}
		}
		return chosenSymbol;
	}
}
