package com.model;

import java.util.List;

public class MockDeck implements DeckInterface {

	private List<CardInterface> cards;
	private int cardIndex;

	public MockDeck() {
		cardIndex = 0;
	}

	@Override
	public List<CardInterface> getAllCards() {
		return null;
	}

	@Override
	public CardInterface dealCard() {
		CardInterface cardInterface = cards.get(cardIndex);
		cardIndex++;
		return cardInterface;
	}

	@Override
	public void shuffle() {
	}

	public void setCards(List<CardInterface> asList) {
		this.cards = asList;

	}
}
