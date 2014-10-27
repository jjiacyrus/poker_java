package com.model;

import java.util.List;

public interface HandInterface {

	public List<Card> getCards();
	
	public Rank getHighCardRank();
	
	public List<Rank> getPairRanks();
	
	public Rank getThreeOfAKindRank();
	
	public Rank getFourOfAKindRank();
	
	public boolean isStraight();
	
	public boolean isFlush();
	
	public Rank getKickerValue();
}
