package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	@Test
	public void testImplementsInterface() throws Exception {
	}

	@Test
	public void testConstructorAndGets() throws Exception {
		Card card = new Card(Rank.FOUR, Suit.SPADES);
		assertEquals(Rank.FOUR, card.getRank());
		assertEquals(Suit.SPADES, card.getSuit());
	}
	
	@Test
	public void testEquals() throws Exception {
		Card original = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card equals = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card differentRank = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card differentSuit = new Card(Rank.EIGHT, Suit.HEARTS);
		Card differentEverything = new Card(Rank.FOUR, Suit.HEARTS);
		
		assertEquals(original, equals);
		assertNotEquals(original, differentRank);
		assertNotEquals(original, differentSuit);
		assertNotEquals(original, differentEverything);
		assertNotEquals(original, null);
		assertNotEquals(original, new Object());	
	}
	
	@Test
	public void testCompare_WorksByRank() throws Exception{
		Card card1 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		Card card2 = new Card(Rank.EIGHT, Suit.HEARTS);
		Card card3= new Card(Rank.SEVEN, Suit.DIAMONDS);
		Card card4 = new Card(Rank.NINE, Suit.DIAMONDS);
		
		
		assertEquals(0, card1.compareTo(card2));
		assertEquals(-1, card1.compareTo(card4));
		assertEquals(1, card1.compareTo(card3));
	}
}
