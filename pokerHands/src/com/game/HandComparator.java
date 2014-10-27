package com.game;

import com.model.HandInterface;

public class HandComparator implements HandComparatorInterface {

	private HandEvaluatorInterface handEvaluator;

	public HandComparator(HandEvaluatorInterface handEvaluator) {
		this.handEvaluator = handEvaluator;
	}

	@Override
	public Winner determineWinner(HandInterface hand1, HandInterface hand2) {
		HandValueInterface hand1Value = handEvaluator.evaluateHand(hand1);
		HandValueInterface hand2Value = handEvaluator.evaluateHand(hand2);
		if(hand1Value.value() > hand2Value.value()){
			return Winner.PLAYER_ONE;
		}
		if(hand2Value.value() > hand1Value.value()){
			return Winner.PLAYER_TWO;
		}
		return hand1Value.getTieResolver().resolve(hand1, hand2);
	}

	public HandEvaluatorInterface getEvaluator() {
		return handEvaluator;
	}

}
