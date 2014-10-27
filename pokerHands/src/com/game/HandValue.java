package com.game;

import com.game.resolver.FourOfAKindResolver;
import com.game.resolver.FullHouseResolver;
import com.game.resolver.HandValueResolver;
import com.game.resolver.HighCardResolver;
import com.game.resolver.ThreeOfAKindResolver;
import com.game.resolver.TwoOfAKindResolver;
import com.game.resolver.TwoPairResolver;

public enum HandValue implements HandValueInterface {
	HIGH_CARD(1, HighCardResolver.SINGLETON), TWO_OF_A_KIND(2,
			TwoOfAKindResolver.SINGLETON), TWO_PAIR(3,
			TwoPairResolver.SINGLETON), THREE_OF_A_KIND(4,
			ThreeOfAKindResolver.SINGLETON), STRAIGHT(5,
			HighCardResolver.SINGLETON), FLUSH(6, HighCardResolver.SINGLETON), FULLHOUSE(
			7, FullHouseResolver.SINGLETON), FOUR_OF_A_KIND(8,
			FourOfAKindResolver.SINGLETON), STRAIGHT_FLUSH(9,
			HighCardResolver.SINGLETON);

	private int value;
	private HandValueResolver tieResolver;

	private HandValue(int value, HandValueResolver tieResolver) {
		this.value = value;
		this.tieResolver = tieResolver;
	}

	@Override
	public int value() {
		return value;
	}

	
	@Override
	public HandValueResolver getTieResolver() {
		return tieResolver;
	}

}
