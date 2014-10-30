package com.game;

import java.util.HashMap;

import com.game.euler.TwoHandsInterface;

public class MockHandComparator implements HandComparatorInterface {

	private HashMap<TwoHandsInterface, Winner> handsToWinner;

	public MockHandComparator() {
		this.handsToWinner = new HashMap<TwoHandsInterface, Winner>();
	}

	@Override
	public Winner determineWinner(TwoHandsInterface twoHands) {
		if (handsToWinner.containsKey(twoHands)) {
			return handsToWinner.get(twoHands);
		}
		return Winner.TIE;
	}

	public void setWinnerForHands(TwoHandsInterface hands, Winner winner) {
		handsToWinner.put(hands, winner);
	}
}
