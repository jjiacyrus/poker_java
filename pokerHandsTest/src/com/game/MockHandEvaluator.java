package com.game;

import java.util.HashMap;

import com.model.HandInterface;

public class MockHandEvaluator implements HandEvaluatorInterface {
	private HashMap<MockHand, HandValueInterface> handValues;

	public MockHandEvaluator() {
		this.handValues = new HashMap<MockHand, HandValueInterface>();
	}

	@Override
	public HandValueInterface evaluateHand(HandInterface hand) {
		if(handValues.containsKey(hand)){
			return this.handValues.get(hand);
		}
		return HandValue.HIGH_CARD;
	}

	public void setHandValue(MockHand mockHand, HandValueInterface value) {
		handValues.put(mockHand, value);
	}

}
