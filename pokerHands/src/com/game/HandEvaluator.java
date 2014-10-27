package com.game;

import com.model.HandInterface;
import com.model.Rank;

public class HandEvaluator implements HandEvaluatorInterface {

	@Override
	public HandValueInterface evaluateHand(HandInterface hand) {
		if (hand.isFlush() && hand.isStraight()) {
			return HandValue.STRAIGHT_FLUSH;
		}
		if (!hand.getFourOfAKindRank().equals(Rank.NULL)) {
			return HandValue.FOUR_OF_A_KIND;
		}
		if (!hand.getThreeOfAKindRank().equals(Rank.NULL)
				&& hand.getPairRanks().size() == 1) {
			return HandValue.FULLHOUSE;
		}
		if(hand.isFlush()){
			return HandValue.FLUSH;
		}
		if(hand.isStraight()){
			return HandValue.STRAIGHT;
		}
		if(!hand.getThreeOfAKindRank().equals(Rank.NULL)){
			return HandValue.THREE_OF_A_KIND;
		}
		if(hand.getPairRanks().size() == 2){
			return HandValue.TWO_PAIR;
		}
		if(hand.getPairRanks().size() == 1){
			return HandValue.TWO_OF_A_KIND;
		}
		return HandValue.HIGH_CARD;
	}
}
