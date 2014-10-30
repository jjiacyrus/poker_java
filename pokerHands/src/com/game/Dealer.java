package com.game;

import java.util.ArrayList;
import java.util.List;

import com.model.CardInterface;
import com.model.DeckInterface;
import com.model.Hand;
import com.model.HandInterface;

public class Dealer implements DealerInterface {

	private DeckInterface deck;

	public Dealer(DeckInterface deck) {
		this.deck = deck;
	}

	@Override
	public List<HandInterface> dealHands(int numberOFHands) {
		List<CardInterface> cardPool = dealCards(numberOFHands);
		ArrayList<HandInterface> hands = dealHands(numberOFHands, cardPool);
		return hands;
	}

	private ArrayList<HandInterface> dealHands(int numberOFHands,
			List<CardInterface> cardPool) {
		ArrayList<HandInterface> hands = new ArrayList<HandInterface>();
		for (int i = 0; i < numberOFHands; i++) {
			hands.add(new Hand(cardPool.get(i),
					cardPool.get(i + numberOFHands), cardPool.get(i + 2
							* numberOFHands), cardPool.get(i + 3
							* numberOFHands), cardPool.get(i + 4
							* numberOFHands)));
		}
		return hands;
	}

	private List<CardInterface> dealCards(int numberOFHands) {
		List<CardInterface> cardPool = new ArrayList<CardInterface>();
		for (int i = 0; i < numberOFHands * 5; i++) {
			cardPool.add(deck.dealCard());
		}
		return cardPool;
	}

}
