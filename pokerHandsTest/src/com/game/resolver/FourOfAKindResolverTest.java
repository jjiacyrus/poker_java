package com.game.resolver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TestHelper;
import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class FourOfAKindResolverTest {
	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class,
				FourOfAKindResolver.class.getSuperclass());
	}

	@Test
	public void testIsASingleton() throws Exception {
		assertEquals(0, FourOfAKindResolver.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(FourOfAKindResolver.class,
				FourOfAKindResolver.SINGLETON);
	}

	@Test
	public void testPlayerOneWins() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setFourOfAKindRank(Rank.FIVE);
		hand2.setFourOfAKindRank(Rank.TWO);

		assertEquals(Winner.PLAYER_ONE,
				FourOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWins() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setFourOfAKindRank(Rank.FIVE);
		hand2.setFourOfAKindRank(Rank.TEN);

		assertEquals(Winner.PLAYER_TWO,
				FourOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerOneWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setFourOfAKindRank(Rank.FIVE);
		hand2.setFourOfAKindRank(Rank.FIVE);
		hand1.setKickerRank(Rank.KING);
		hand2.setKickerRank(Rank.JACK);
		assertEquals(Winner.PLAYER_ONE,
				FourOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setFourOfAKindRank(Rank.FIVE);
		hand2.setFourOfAKindRank(Rank.FIVE);
		hand1.setKickerRank(Rank.FIVE);
		hand2.setKickerRank(Rank.JACK);
		assertEquals(Winner.PLAYER_TWO,
				FourOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testTie() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setFourOfAKindRank(Rank.FIVE);
		hand2.setFourOfAKindRank(Rank.FIVE);
		hand1.setKickerRank(Rank.JACK);
		hand2.setKickerRank(Rank.JACK);
		assertEquals(Winner.TIE,
				FourOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
}
