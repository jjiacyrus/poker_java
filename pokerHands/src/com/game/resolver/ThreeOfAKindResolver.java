package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;

public class ThreeOfAKindResolver extends HandValueResolver {

	public static final ThreeOfAKindResolver SINGLETON = new ThreeOfAKindResolver();

	private ThreeOfAKindResolver() {
	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		Winner comparison = compareRanks(hand1.getThreeOfAKindRank(),
				hand2.getThreeOfAKindRank());
		if (!comparison.equals(Winner.TIE)) {
			return comparison;
		} else {
			return compareRanks(hand1.getKickerValue(), hand2.getKickerValue());
		}
	}

}
