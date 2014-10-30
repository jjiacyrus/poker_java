package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class NullCardTest {
	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(CardInterface.class, NullCard.class.getInterfaces()[0]);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullCard.class.getConstructors().length);
		assertEquals(NullCard.class, NullCard.NULL.getClass());
	}

	@Test
	public void testRankAndValue() throws Exception {
		assertEquals(Rank.NULL, NullCard.NULL.getRank());
		assertEquals(Suit.NULL, NullCard.NULL.getSuit());
	}
}
