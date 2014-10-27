package com.game;

import com.model.HandInterface;

public interface HandComparatorInterface {

	public Winner determineWinner(HandInterface hand1, HandInterface hand2);
}
