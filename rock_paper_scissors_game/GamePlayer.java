//Marija Mumm, 2232817m
package game;

import java.util.ArrayList;
import java.util.List;

public abstract class GamePlayer {
	String name;
	// stores the sequence of symbols chosen by the current player
	List<Symbol> playerHistory = new ArrayList<Symbol>();
	// represents the symbols chosen by the opponent
	List<Symbol> opponentHistory = new ArrayList<Symbol>();

	// constructor
	public GamePlayer(String name) {
		this.name = name;
	}

	// getter
	public String getName() {
		return this.name;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	// adds mySymbol to the end of the current player’s history
	// add otherSymbol to the end of the opponent’s history
	public void addHistory(Symbol mySymbol, Symbol otherSymbol) {
		playerHistory.add(mySymbol);
		opponentHistory.add(otherSymbol);
	}

	public abstract Symbol chooseSymbol();
}
