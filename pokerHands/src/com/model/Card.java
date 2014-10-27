package com.model;

public class Card implements  Comparable<Card> {

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card other = (Card) obj;
			return other.rank.equals(this.rank) && other.suit.equals(this.suit);
		}
		return false;

	}

	@Override
	public int compareTo(Card o) {
		int compare = this.rank.compareTo(o.rank);
		return compare;
		
	}
}
