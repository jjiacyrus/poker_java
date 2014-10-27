package com.game.resolver;

import com.game.Winner;
import com.model.HandInterface;

public class MockHandResolver extends HandValueResolver {

	private Winner winnerToReturn;
	private HandInterface hand1ToResolve;
	private HandInterface hand2ToResolve;

	@Override
	public Winner resolve(HandInterface hand1, HandInterface hand2) {
		this.hand1ToResolve = hand1;
		this.hand2ToResolve = hand2;
		return winnerToReturn;
	}

	public HandInterface getHand1ToResolve() {
		return hand1ToResolve;
	}

	public HandInterface getHand2ToResolve() {
		return hand2ToResolve;
	}

	public void setWinnerToReturn(Winner winnerToReturn) {
		this.winnerToReturn = winnerToReturn;
	}

}
