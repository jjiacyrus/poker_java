package com.model;

public class MockCard implements CardInterface {

	@Override
	public int compareTo(CardInterface o) {
		return 0;
	}

	@Override
	public Suit getSuit() {
		return Suit.NULL;
	}

	@Override
	public Rank getRank() {
		return Rank.NULL;
	}

}
