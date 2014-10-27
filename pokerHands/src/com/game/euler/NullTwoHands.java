package com.game.euler;

import com.model.HandInterface;
import com.model.NullHand;

public class NullTwoHands implements TwoHandsInterface {

	public static final NullTwoHands NULL = new NullTwoHands();

	private NullTwoHands() {
	}

	@Override
	public HandInterface getHand1() {
		return NullHand.NULL;
	}

	@Override
	public HandInterface getHand2() {
		return NullHand.NULL;
	}

}
