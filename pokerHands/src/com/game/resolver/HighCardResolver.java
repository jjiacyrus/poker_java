package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;

public class HighCardResolver extends HandValueResolver {

	public static HighCardResolver SINGLETON = new HighCardResolver();

	private HighCardResolver() {
	}

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		return compareRanks(hand1.getHighCardRank(), hand2.getHighCardRank());
	}

}
