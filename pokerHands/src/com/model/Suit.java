package com.model;

public enum Suit {
	HEARTS('H'), CLUBS('C'), DIAMONDS('D'), SPADES('S'), NULL('N');
	private char abbreviation;
	private Suit(char abbreviation){
		this.abbreviation = abbreviation;
		
	}
	public static Suit findByAbbreviation(char abbreviation) {
	
		for (Suit suit : Suit.values()) {
			if(suit.abbreviation == abbreviation){
				return suit;
			}
		}
		return Suit.NULL;
	}
}
