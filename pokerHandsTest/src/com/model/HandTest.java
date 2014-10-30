package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HandTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(HandInterface.class, Hand.class.getInterfaces()[0]);
	}

	@Test
	public void testConstructorWillSortCardsByValue() throws Exception {
		Card card1 = new Card(Rank.ACE, Suit.DIAMONDS);
		Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
		Card card3 = new Card(Rank.NINE, Suit.HEARTS);
		Card card4 = new Card(Rank.TWO, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(5, hand.getCards().size());
		assertEquals(card4, hand.getCards().get(0));
		assertEquals(card5, hand.getCards().get(1));
		assertEquals(card3, hand.getCards().get(2));
		assertEquals(card2, hand.getCards().get(3));
		assertEquals(card1, hand.getCards().get(4));
	}

	@Test
	public void testHighCard() throws Exception {
		Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
		Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
		Card card3 = new Card(Rank.NINE, Suit.HEARTS);
		Card card4 = new Card(Rank.TWO, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(card2.getRank(), hand.getHighCardRank());
	}

	@Test
	public void testPairs() throws Exception {
		Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
		Card card2 = new Card(Rank.JACK, Suit.SPADES);
		Card card3 = new Card(Rank.NINE, Suit.HEARTS);
		Card card4 = new Card(Rank.NINE, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(2, hand.getPairRanks().size());
		assertEquals(Rank.NINE, hand.getPairRanks().get(0));
		assertEquals(Rank.JACK, hand.getPairRanks().get(1));

	}

	@Test
	public void testPairsWhenThereAreNoPairs() throws Exception {
		Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
		Card card2 = new Card(Rank.QUEEN, Suit.SPADES);
		Card card3 = new Card(Rank.NINE, Suit.HEARTS);
		Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(0, hand.getPairRanks().size());
	}

	@Test
	public void testGetThreeOfAKindRank() throws Exception {
		Card card1 = new Card(Rank.QUEEN, Suit.DIAMONDS);
		Card card2 = new Card(Rank.QUEEN, Suit.SPADES);
		Card card3 = new Card(Rank.QUEEN, Suit.HEARTS);
		Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(Rank.QUEEN, hand.getThreeOfAKindRank());
	}

	@Test
	public void testGetThreeOfAKindRankWhenThereIsNoThreeOfAKind()
			throws Exception {
		Card card1 = new Card(Rank.QUEEN, Suit.DIAMONDS);
		Card card2 = new Card(Rank.QUEEN, Suit.SPADES);
		Card card3 = new Card(Rank.JACK, Suit.HEARTS);
		Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(Rank.NULL, hand.getThreeOfAKindRank());
	}

	@Test
	public void testGetFourOfAKindRank() throws Exception {
		Card card1 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card card2 = new Card(Rank.EIGHT, Suit.SPADES);
		Card card3 = new Card(Rank.EIGHT, Suit.HEARTS);
		Card card4 = new Card(Rank.EIGHT, Suit.CLUBS);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(Rank.EIGHT, hand.getFourOfAKindRank());
	}

	@Test
	public void testGetFourOfAKindRankWhenThereIsNoFourOfAKind()
			throws Exception {
		Card card1 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card card2 = new Card(Rank.EIGHT, Suit.SPADES);
		Card card3 = new Card(Rank.EIGHT, Suit.HEARTS);
		Card card4 = new Card(Rank.FIVE, Suit.CLUBS);
		Card card5 = new Card(Rank.FIVE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertEquals(Rank.NULL, hand.getFourOfAKindRank());
	}

	@Test
	public void testIsStraight() throws Exception {
		Card card1 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card card2 = new Card(Rank.FIVE, Suit.SPADES);
		Card card3 = new Card(Rank.SIX, Suit.HEARTS);
		Card card4 = new Card(Rank.SEVEN, Suit.CLUBS);
		Card card5 = new Card(Rank.EIGHT, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertTrue(hand.isStraight());
	}
	
	@Test
	public void testIsNotStraight() throws Exception {
		Card card1 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card card2 = new Card(Rank.THREE, Suit.SPADES);
		Card card3 = new Card(Rank.SIX, Suit.HEARTS);
		Card card4 = new Card(Rank.SEVEN, Suit.CLUBS);
		Card card5 = new Card(Rank.NINE, Suit.SPADES);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertFalse(hand.isStraight());
	}
	
	@Test
	public void testIsFlush() throws Exception {
		Card card1 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
		Card card3 = new Card(Rank.SIX, Suit.DIAMONDS);
		Card card4 = new Card(Rank.SEVEN, Suit.DIAMONDS);
		Card card5 = new Card(Rank.EIGHT, Suit.DIAMONDS);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertTrue(hand.isFlush());
	}
	
	@Test
	public void testIsNotAFlush() throws Exception {
		Card card1 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card card2 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card card3 = new Card(Rank.SIX, Suit.DIAMONDS);
		Card card4 = new Card(Rank.SEVEN, Suit.CLUBS);
		Card card5 = new Card(Rank.NINE, Suit.DIAMONDS);

		Hand hand = new Hand(card1, card2, card3, card4, card5);

		assertFalse(hand.isFlush());
	}
	
	@Test
	public void testGetKickerValue() throws Exception {
		Card card1 = new Card(Rank.THREE, Suit.CLUBS);
		Card card2 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card card3 = new Card(Rank.SIX, Suit.DIAMONDS);
		Card card4 = new Card(Rank.SIX, Suit.CLUBS);
		Card card5 = new Card(Rank.FOUR, Suit.DIAMONDS);

		Hand hand = new Hand(card1, card2, card3, card4, card5);
		assertEquals(Rank.FOUR, hand.getKickerValue());
	}
}
