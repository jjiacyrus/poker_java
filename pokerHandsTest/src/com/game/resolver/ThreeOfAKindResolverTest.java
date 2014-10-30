package com.game.resolver;

import static org.junit.Assert.*;

import org.junit.Test;

import com.TestHelper;
import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class ThreeOfAKindResolverTest {
	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class,
				ThreeOfAKindResolver.class.getSuperclass());
	}

	@Test
	public void testIsASingleton() throws Exception {
		assertEquals(0, ThreeOfAKindResolver.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(ThreeOfAKindResolver.class,
				ThreeOfAKindResolver.SINGLETON);
	}

	@Test
	public void testPlayerOneWins() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.JACK);
		hand2.setThreeOfAKindRank(Rank.NINE);

		assertEquals(Winner.PLAYER_ONE,
				ThreeOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWins() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.FOUR);
		hand2.setThreeOfAKindRank(Rank.NINE);

		assertEquals(Winner.PLAYER_TWO,
				ThreeOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerOneWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.JACK);
		hand1.setKickerRank(Rank.ACE);
		hand2.setThreeOfAKindRank(Rank.JACK);
		hand2.setKickerRank(Rank.JACK);
		assertEquals(Winner.PLAYER_ONE,
				ThreeOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.NINE);
		hand1.setKickerRank(Rank.JACK);
		hand2.setThreeOfAKindRank(Rank.NINE);
		hand2.setKickerRank(Rank.QUEEN);
		assertEquals(Winner.PLAYER_TWO,
				ThreeOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testTie() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.NINE);
		hand1.setKickerRank(Rank.JACK);
		hand2.setThreeOfAKindRank(Rank.NINE);
		hand2.setKickerRank(Rank.JACK);

		assertEquals(Winner.TIE,
				ThreeOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
}
