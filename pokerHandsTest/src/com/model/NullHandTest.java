package com.model;

import static org.junit.Assert.*;
import static com.TestHelper.*;
import org.junit.Test;

public class NullHandTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(HandInterface.class, NullHand.class);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullHand.class.getConstructors().length);
		assertIsOfTypeAndGet(NullHand.class, NullHand.NULL);
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
