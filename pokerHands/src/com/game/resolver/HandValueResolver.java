package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;
import com.model.Rank;

public abstract class HandValueResolver {
	
	public abstract Winner resolve(HandInterface hand1, HandInterface hand2);

	protected Winner compareRanks(Rank hand1Rank, Rank hand2Rank) {
		if (hand1Rank.value() > hand2Rank.value()) {
			return Winner.PLAYER_ONE;
		}
		if (hand2Rank.value() > hand1Rank.value()) {
			return Winner.PLAYER_TWO;
		}
		return Winner.TIE;
	}
}
