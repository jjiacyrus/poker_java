package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;

public class FullHouseResolver extends HandValueResolver {

	public static final FullHouseResolver SINGLETON = new FullHouseResolver();

	private FullHouseResolver() {

	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		Winner threeOfAKindComparison = compareRanks(
				hand1.getThreeOfAKindRank(), hand2.getThreeOfAKindRank());
		if (!threeOfAKindComparison.equals(Winner.TIE)) {
			return threeOfAKindComparison;
		}
		
		Winner twoOfAKindComparison = compareRanks(hand1.getPairRanks().get(0),
				hand2.getPairRanks().get(0));
		if (!twoOfAKindComparison.equals(Winner.TIE)) {
			return twoOfAKindComparison;
		}
		return Winner.TIE;
	}

}
