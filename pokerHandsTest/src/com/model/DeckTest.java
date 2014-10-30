package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DeckTest {

	@Test
	public void testGetAllCards() throws Exception {
		Deck deck = new Deck();
		List<CardInterface> allCards = deck.getAllCards();
		List<Suit> allNonNullSuits = getNonNullSuits();
		List<Rank> allNonNullRanks = getNonNullRanks();

		for (Suit suit : allNonNullSuits) {
			for (Rank rank : allNonNullRanks) {
				assertTrue(allCards.contains(new Card(rank, suit)));
			}
		}
		assertEquals(52, allCards.size());
	}

	private List<Rank> getNonNullRanks() {
		List<Rank> allNonNullRanks = new ArrayList<Rank>(Arrays.asList(Rank
				.values()));
		allNonNullRanks.remove(Rank.NULL);
		return allNonNullRanks;
	}

	private List<Suit> getNonNullSuits() {
		List<Suit> allNonNullSuits = new ArrayList<Suit>(Arrays.asList(Suit
				.values()));
		allNonNullSuits.remove(Suit.NULL);
		return allNonNullSuits;
	}

	@Test
	public void testShuffleWillChangeOrderOfAllCards() throws Exception {
		Deck deck = new Deck();
		List<CardInterface> allCards = new ArrayList<CardInterface>(
				deck.getAllCards());
		deck.shuffle();
		List<CardInterface> allCardsPostShuffle = deck.getAllCards();
		assertEquals(allCards.size(), allCardsPostShuffle.size());
		checkCollectionHasSameContentWithDifferentOrder(allCards,
				allCardsPostShuffle);
	}

	@Test
	public void testDealCardWillGiveYouTheTopCardOffTheDeckUntilYouRunOutOfCards() {
		Deck deck = new Deck();
		for (Suit suit : getNonNullSuits()) {
			for (Rank rank : getNonNullRanks()) {
				assertEquals(new Card(rank, suit), deck.dealCard());
			}
		}
		assertEquals(NullCard.NULL, deck.dealCard());
		assertEquals(NullCard.NULL, deck.dealCard());
		assertEquals(NullCard.NULL, deck.dealCard());
	}

	@Test
	public void testShuffleWillReplenishTheDeck() throws Exception {
		Deck deck = new Deck();

		for (int i = 0; i < 52; i++) {
			deck.dealCard();
		}
		assertEquals(NullCard.NULL, deck.dealCard());

		deck.shuffle();

		assertEquals(Card.class, deck.dealCard().getClass());
	}

	private void checkCollectionHasSameContentWithDifferentOrder(
			List<CardInterface> allCards,
			List<CardInterface> allCardsPostShuffle) {
		for (CardInterface card : allCardsPostShuffle) {
			assertTrue(allCards.contains(card));
		}
		boolean differentOrder = false;
		for (int i = 0; i < allCards.size(); i++) {
			if (!allCards.get(i).equals(allCardsPostShuffle.get(i))) {
				differentOrder = true;
			}
		}
		assertTrue("The cards were not in a different order", differentOrder);
	}
}
