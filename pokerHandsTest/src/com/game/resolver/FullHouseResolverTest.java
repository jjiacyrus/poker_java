package com.game.resolver;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.TestHelper;
import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class FullHouseResolverTest {

	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class,
				FullHouseResolver.class.getSuperclass());
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, FullHouseResolver.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(FullHouseResolver.class,
				FullHouseResolver.SINGLETON);
	}

	@Test
	public void testPlayerOneWinsThreeOfAKindValue() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.TEN);
		hand2.setThreeOfAKindRank(Rank.NINE);

		assertEquals(Winner.PLAYER_ONE,
				FullHouseResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWinsThreeOfAKindValue() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.FOUR);
		hand2.setThreeOfAKindRank(Rank.NINE);

		assertEquals(Winner.PLAYER_TWO,
				FullHouseResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerOneWinsTwoOfAKindValue() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.TEN);
		hand2.setThreeOfAKindRank(Rank.TEN);

		hand1.setPairRanks(Arrays.asList(Rank.JACK));
		hand2.setPairRanks(Arrays.asList(Rank.FIVE));

		assertEquals(Winner.PLAYER_ONE,
				FullHouseResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testPlayerTwoWinsTwoOfAKindValue() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.FOUR);
		hand2.setThreeOfAKindRank(Rank.FOUR);

		hand1.setPairRanks(Arrays.asList(Rank.JACK));
		hand2.setPairRanks(Arrays.asList(Rank.KING));

		assertEquals(Winner.PLAYER_TWO,
				FullHouseResolver.SINGLETON.resolve(hand1, hand2));
	}

	@Test
	public void testTie() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		hand1.setThreeOfAKindRank(Rank.FOUR);
		hand2.setThreeOfAKindRank(Rank.FOUR);

		hand1.setPairRanks(Arrays.asList(Rank.JACK));
		hand2.setPairRanks(Arrays.asList(Rank.JACK));

		assertEquals(Winner.TIE,
				FullHouseResolver.SINGLETON.resolve(hand1, hand2));
	}
}
