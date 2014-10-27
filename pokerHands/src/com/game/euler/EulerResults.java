package com.game.euler;

import com.game.Winner;

public class EulerResults {
	private int playerTwoWins;
	private int playerOneWins;
	private int ties;

	public EulerResults() {
		this.playerOneWins = 0;
		this.playerTwoWins = 0;
		this.ties = 0;
	}

	public int getPlayerOneWins() {
		return playerOneWins;
	}

	public int getPlayerTwoWins() {
		return playerTwoWins;
	}

	public int getTies() {
		return ties;
	}

	public void addResult(Winner winner) {
		if (winner.equals(Winner.PLAYER_ONE)) {
			playerOneWins++;
		} else if (winner.equals(Winner.PLAYER_TWO)) {
			playerTwoWins++;
		} else {
			ties++;
		}
	}
}
