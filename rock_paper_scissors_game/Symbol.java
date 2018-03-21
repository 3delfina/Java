//Marija Mumm, 2232817m
package game;

public enum Symbol {
	ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
	// compares the current symbol to another and returns one of the three
	// possible GameResult values

	// Rock defeats Lizard, Scissors
	// Paper defeats Rock, Spock
	// Scissors defeats Paper, Lizard
	// Lizard defeats Spock, Paper
	// Spock defeats Scissors, Rock

	public GameResult getResult(Symbol s) {
		if (this.equals(s)) {
			return GameResult.DRAW;
		}

		else if (this.equals(ROCK)) {

			if (s.equals(LIZARD) || s.equals(SCISSORS)) {
				return GameResult.WIN;
			} else {
				return GameResult.LOSE;
			}
		} else if (this.equals(PAPER)) {

			if (s.equals(ROCK) || s.equals(SPOCK)) {
				return GameResult.WIN;
			} else {
				return GameResult.LOSE;
			}
		}

		else if (this.equals(SCISSORS)) {

			if (s.equals(PAPER) || s.equals(LIZARD)) {
				return GameResult.WIN;
			} else {
				return GameResult.LOSE;
			}
		}

		else if (this.equals(LIZARD)) {

			if (s.equals(SPOCK) || s.equals(PAPER)) {
				return GameResult.WIN;
			} else {
				return GameResult.LOSE;
			}
		}

		else if (this.equals(SPOCK)) {

			if (s.equals(SCISSORS) || s.equals(ROCK)) {
				return GameResult.WIN;
			} else {
				return GameResult.LOSE;
			}
		}

		return GameResult.DRAW;

	}
}
