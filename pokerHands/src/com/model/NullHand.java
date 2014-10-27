package com.model;

import java.util.Arrays;
import java.util.List;

public class NullHand implements HandInterface {

	public static final NullHand NULL = new NullHand();

	private NullHand() {
	}

	@Override
	public List<Card> getCards() {
		return Arrays.asList();
	}

	@Override
	public Rank getHighCardRank() {
		return Rank.NULL;
	}

	@Override
	public List<Rank> getPairRanks() {
		return Arrays.asList();
	}

	@Override
	public Rank getThreeOfAKindRank() {
		return Rank.NULL;
	}

	@Override
	public Rank getFourOfAKindRank() {
		return Rank.NULL;
	}

	@Override
	public boolean isStraight() {
		return false;
	}

	@Override
	public boolean isFlush() {
		return false;
	}

	@Override
	public Rank getKickerValue() {
		return Rank.NULL;
	}

}
