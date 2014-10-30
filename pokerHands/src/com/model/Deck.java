package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckInterface {
	private List<CardInterface> allCards;
	private int cardIndex;

	public Deck() {
		allCards = new ArrayList<CardInterface>();
		cardIndex = 0;
		for (Suit suit : getNonNullSuits()) {
			for (Rank rank : getNonNullRanks()) {
				allCards.add(new Card(rank, suit));
			}
		}
	}

	private List<Rank> getNonNullRanks() {
		ArrayList<Rank> ranks = new ArrayList<Rank>(
				Arrays.asList(Rank.values()));
		ranks.remove(Rank.NULL);
		return ranks;
	}

	private List<Suit> getNonNullSuits() {
		ArrayList<Suit> suits = new ArrayList<Suit>(
				Arrays.asList(Suit.values()));
		suits.remove(Suit.NULL);
		return suits;
	}

	@Override
	public List<CardInterface> getAllCards() {
		return allCards;
	}

	@Override
	public CardInterface dealCard() {
		if (cardIndex < allCards.size()) {
			CardInterface card = allCards.get(cardIndex);
			cardIndex++;
			return card;
		}
		return NullCard.NULL;
	}

	@Override
	public void shuffle() {
		cardIndex = 0;
		Collections.shuffle(allCards);
	}

}
