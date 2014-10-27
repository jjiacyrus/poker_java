package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;
import com.model.Rank;

public class TwoOfAKindResolver extends HandValueResolver {

	public static final TwoOfAKindResolver SINGLETON = new TwoOfAKindResolver();

	private TwoOfAKindResolver() {
	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		Rank hand1Rank = hand1.getPairRanks().get(0);
		Rank hand2Rank = hand2.getPairRanks().get(0);

		Winner comparison = compareRanks(hand1Rank, hand2Rank);
		if (!comparison.equals(Winner.TIE)) {
			return comparison;
		} else {
			return compareRanks(hand1.getKickerValue(), hand2.getKickerValue());
		}
	}

}
