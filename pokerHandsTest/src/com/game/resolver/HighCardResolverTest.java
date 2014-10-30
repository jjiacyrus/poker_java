package com.game.resolver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TestHelper;
import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class HighCardResolverTest {
	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class,
				HighCardResolver.class.getSuperclass());
	}

	@Test
	public void testIsASingleton() throws Exception {
		assertEquals(0, HighCardResolver.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(HighCardResolver.class,
				HighCardResolver.SINGLETON);
	}

	@Test
	public void testPlayerOneWins() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setHighCardRank(Rank.ACE);

		MockHand hand2 = new MockHand();
		hand2.setHighCardRank(Rank.KING);

		assertEquals(Winner.PLAYER_ONE,
				HighCardResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWins() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setHighCardRank(Rank.JACK);

		MockHand hand2 = new MockHand();
		hand2.setHighCardRank(Rank.KING);

		assertEquals(Winner.PLAYER_TWO,
				HighCardResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTie() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setHighCardRank(Rank.JACK);

		MockHand hand2 = new MockHand();
		hand2.setHighCardRank(Rank.JACK);

		assertEquals(Winner.TIE,
				HighCardResolver.SINGLETON.resolve(hand1, hand2));
	}
}
