//Marija Mumm, 2232817m
package game;

public class ComputerPlayer extends GamePlayer {

	// constructor
	public ComputerPlayer(String name) {
		super(name);
	}

	// find the most frequent Symbol in the opponent’s history and choose the symbol
	// to defeat it
	@Override
	public Symbol chooseSymbol() {
		Symbol popularSymbol = null;
		Symbol chosenSymbol = null;
		// max is 1 as most frequent Symbol must have frequency >1
		int max = 1;
		for (Symbol s : Symbol.values()) {
			// count the Symbol frequencies in the history using a stream
			long frequency = this.opponentHistory.stream().filter(x -> x.equals(s)).count();

			if ((int) frequency > max) {
				max = (int) frequency;
				popularSymbol = s;
			}
		}
		// if not most-frequent symbol is found in the list, return a random one
		if (popularSymbol == null) {
			int index = (int) (Math.random() * 5);
			chosenSymbol = Symbol.values()[index];
		} else {
			// choose the symbol to defeat the most-frequent symbol
			for (Symbol s : Symbol.values()) {
				if (s.getResult(popularSymbol).equals(GameResult.WIN)) {
					chosenSymbol = s;
				}
			}

		}

		return chosenSymbol;
	}
}
