package com.game;

import com.game.euler.TwoHandsInterface;

public class HandComparator implements HandComparatorInterface {

	private HandEvaluatorInterface handEvaluator;

	public HandComparator(HandEvaluatorInterface handEvaluator) {
		this.handEvaluator = handEvaluator;
	}

	@Override
	public Winner determineWinner(TwoHandsInterface twoHands) {
		HandValueInterface hand1Value = handEvaluator.evaluateHand(twoHands.getHand1());
		HandValueInterface hand2Value = handEvaluator.evaluateHand(twoHands.getHand2());
		if (hand1Value.value() > hand2Value.value()) {
			return Winner.PLAYER_ONE;
		}
		if (hand2Value.value() > hand1Value.value()) {
			return Winner.PLAYER_TWO;
		}
		return hand1Value.getTieResolver().resolve(twoHands.getHand1(), twoHands.getHand2());
	}

	public HandEvaluatorInterface getEvaluator() {
		return handEvaluator;
	}

}
