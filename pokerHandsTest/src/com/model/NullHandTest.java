package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class NullHandTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(HandInterface.class, NullHand.class.getInterfaces()[0]);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullHand.class.getConstructors().length);
		assertEquals(NullHand.class, NullHand.NULL.getClass());
	}

	@Test
	public void testValues() throws Exception {
		assertEquals(0, NullHand.NULL.getCards().size());
		assertEquals(Rank.NULL, NullHand.NULL.getFourOfAKindRank());
		assertEquals(Rank.NULL, NullHand.NULL.getHighCardRank());
		assertEquals(Rank.NULL, NullHand.NULL.getKickerValue());
		assertEquals(Rank.NULL, NullHand.NULL.getThreeOfAKindRank());
		assertFalse(NullHand.NULL.isFlush());
		assertFalse(NullHand.NULL.isStraight());
		assertEquals(0, NullHand.NULL.getPairRanks().size());
	}
}
