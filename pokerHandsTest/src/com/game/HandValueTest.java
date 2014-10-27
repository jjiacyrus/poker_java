package com.game;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.resolver.FourOfAKindResolver;
import com.game.resolver.FullHouseResolver;
import com.game.resolver.HighCardResolver;
import com.game.resolver.ThreeOfAKindResolver;
import com.game.resolver.TwoOfAKindResolver;
import com.game.resolver.TwoPairResolver;

public class HandValueTest {

	@Test
	public void testIsAnEnum() throws Exception {
		assertTrue(HandValue.class.isEnum());
	}

	@Test
	public void testValeus() throws Exception {
		assertEquals(1, HandValue.HIGH_CARD.value());
		assertEquals(2, HandValue.TWO_OF_A_KIND.value());
		assertEquals(3, HandValue.TWO_PAIR.value());
		assertEquals(4, HandValue.THREE_OF_A_KIND.value());
		assertEquals(5, HandValue.STRAIGHT.value());
		assertEquals(6, HandValue.FLUSH.value());
		assertEquals(7, HandValue.FULLHOUSE.value());
		assertEquals(8, HandValue.FOUR_OF_A_KIND.value());
		assertEquals(9, HandValue.STRAIGHT_FLUSH.value());
	}

	@Test
	public void testGetResolver() throws Exception {
		assertEquals(HighCardResolver.SINGLETON,
				HandValue.HIGH_CARD.getTieResolver());
		assertEquals(TwoOfAKindResolver.SINGLETON,
				HandValue.TWO_OF_A_KIND.getTieResolver());
		assertEquals(TwoPairResolver.SINGLETON,
				HandValue.TWO_PAIR.getTieResolver());
		assertEquals(ThreeOfAKindResolver.SINGLETON,
				HandValue.THREE_OF_A_KIND.getTieResolver());
		assertEquals(HighCardResolver.SINGLETON,
				HandValue.STRAIGHT.getTieResolver());
		assertEquals(HighCardResolver.SINGLETON,
				HandValue.FLUSH.getTieResolver());
		assertEquals(FullHouseResolver.SINGLETON,
				HandValue.FULLHOUSE.getTieResolver());
		assertEquals(FourOfAKindResolver.SINGLETON,
				HandValue.FOUR_OF_A_KIND.getTieResolver());
		assertEquals(HighCardResolver.SINGLETON,
				HandValue.HIGH_CARD.getTieResolver());

	}
}
