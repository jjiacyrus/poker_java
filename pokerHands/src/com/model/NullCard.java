package com.model;

public class NullCard implements CardInterface {

	public static final NullCard NULL = new NullCard();

	private NullCard() {
	}

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
