package com.model;

import static com.TestHelper.assertIsOfInterface;
import static org.junit.Assert.*;

import org.junit.Test;

import com.TestHelper;

public class NullCardTest {
	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(CardInterface.class, NullCard.class);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullCard.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(NullCard.class, NullCard.NULL);
	}

	@Test
	public void testRankAndValue() throws Exception {
		assertEquals(Rank.NULL, NullCard.NULL.getRank());
		assertEquals(Suit.NULL, NullCard.NULL.getSuit());
	}
}
