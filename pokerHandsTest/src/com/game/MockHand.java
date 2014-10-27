package com.game;

import java.util.ArrayList;
import java.util.List;

import com.model.Card;
import com.model.HandInterface;
import com.model.Rank;

public class MockHand implements HandInterface {

	private boolean isFlush;
	private boolean isStraight;
	private Rank fourOfAKindRank;
	private Rank threeOfAKindRank;
	private List<Rank> pairs;
	private Rank highCardRank;
	private Rank kicker;

	public MockHand() {
		fourOfAKindRank = Rank.NULL;
		threeOfAKindRank = Rank.NULL;
		pairs = new ArrayList<Rank>();
		highCardRank = Rank.NULL;
		kicker = Rank.NULL;
	}

	public void setHighCardRank(Rank highCardRank) {
		this.highCardRank = highCardRank;
	}

	public void setFourOfAKindRank(Rank fourOfAKindRank) {
		this.fourOfAKindRank = fourOfAKindRank;
	}

	public void setIsFlush(boolean isFlush) {
		this.isFlush = isFlush;
	}

	public void setIsStraight(boolean isStraight) {
		this.isStraight = isStraight;
	}

	@Override
	public List<Card> getCards() {
		return null;
	}

	@Override
	public Rank getHighCardRank() {
		return highCardRank;
	}

	@Override
	public List<Rank> getPairRanks() {
		return pairs;
	}

	@Override
	public Rank getThreeOfAKindRank() {
		return threeOfAKindRank;
	}

	@Override
	public Rank getFourOfAKindRank() {
		return fourOfAKindRank;
	}

	@Override
	public boolean isStraight() {
		return isStraight;
	}

	@Override
	public boolean isFlush() {
		return isFlush;
	}

	@Override
	public Rank getKickerValue() {
		return kicker;
	}

	public void setThreeOfAKindRank(Rank threeOfAKindRank) {
		this.threeOfAKindRank = threeOfAKindRank;

	}

	public void setPairRanks(List<Rank> pairs) {
		this.pairs = pairs;

	}

	public void setKickerRank(Rank kicker) {
		this.kicker = kicker;
	}

}
