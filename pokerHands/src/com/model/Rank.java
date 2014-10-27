package com.model;

public enum Rank implements Comparable<Rank> {
	TWO(2, '2'), THREE(3, '3'), FOUR(4, '4'), FIVE(5, '5'), SIX(6, '6'), SEVEN(
			7, '7'), EIGHT(8, '8'), NINE(9, '9'), TEN(10, 'T'), JACK(11, 'J'), QUEEN(
			12, 'Q'), KING(13, 'K'), ACE(14, 'A'), NULL(-1, 'N');

	private int value;
	private char abbreviation;

	private Rank(int value, char abbreviation) {
		this.value = value;
		this.abbreviation = abbreviation;

	}

	public int value() {
		return value;
	}



	public static Rank findByAbbreviation(char c) {
		for (Rank rank : Rank.values()) {
			if (rank.abbreviation == c) {
				return rank;
			}
		}
		return Rank.NULL;
	}

}
