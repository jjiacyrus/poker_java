package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;

public class FourOfAKindResolver extends HandValueResolver {

	public static final FourOfAKindResolver SINGLETON = new FourOfAKindResolver();

	private FourOfAKindResolver() {
	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		Winner comparison = compareRanks(hand1.getFourOfAKindRank(), hand2.getFourOfAKindRank());
		if(!comparison.equals(Winner.TIE)){
			return comparison;
		}
		return compareRanks(hand1.getKickerValue(), hand2.getKickerValue());
	}

}
