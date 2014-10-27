package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;
import com.model.Rank;

public class TwoPairResolver extends HandValueResolver {

	public static final TwoPairResolver SINGLETON = new TwoPairResolver();

	private TwoPairResolver() {
	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		Winner highPairComparison = compareHighPair(hand1, hand2);
		if (!highPairComparison.equals(Winner.TIE)) {
			return highPairComparison;
		} else {
			Winner lowPairComparison = compareLowPair(hand1, hand2);
			if(!lowPairComparison.equals(Winner.TIE)){
				return lowPairComparison;
			}
			else{
				return compareRanks(hand1.getKickerValue(), hand2.getKickerValue());
			}
			
		}
	}

	private Winner compareHighPair(HandInterface hand1, HandInterface hand2) {
		Rank hand1Rank = hand1.getPairRanks().get(1);
		Rank hand2Rank = hand2.getPairRanks().get(1);
		return compareRanks(hand1Rank, hand2Rank);
	}

	private Winner compareLowPair(HandInterface hand1, HandInterface hand2) {
		Rank hand1Rank = hand1.getPairRanks().get(0);
		Rank hand2Rank = hand2.getPairRanks().get(0);
		return compareRanks(hand1Rank, hand2Rank);
	}



}
