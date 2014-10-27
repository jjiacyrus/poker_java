package com.game.euler;

import com.model.HandInterface;

public class TwoHands implements TwoHandsInterface {

	private HandInterface hand1;
	private HandInterface hand2;

	public TwoHands(HandInterface hand1, HandInterface hand2) {
		this.hand1 = hand1;
		this.hand2 = hand2;
	}

	@Override
	public HandInterface getHand1() {
		return hand1;
	}

	@Override
	public HandInterface getHand2() {
		return hand2;
	}



}
