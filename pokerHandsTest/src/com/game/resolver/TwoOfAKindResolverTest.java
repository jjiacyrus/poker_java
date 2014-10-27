package com.game.resolver;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class TwoOfAKindResolverTest {
	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class, TwoOfAKindResolver.class.getSuperclass());
	}
	
	@Test
	public void testIsASingleton() throws Exception {
		assertEquals(0, TwoOfAKindResolver.class.getConstructors().length);
		assertEquals(TwoOfAKindResolver.class, TwoOfAKindResolver.SINGLETON.getClass());
	}
	
	@Test
	public void testPlayerOneWins() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.ACE));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.JACK));
		
		assertEquals(Winner.PLAYER_ONE, TwoOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
	@Test
	public void testPlayerTwoWins() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.TEN));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.JACK));
		
		assertEquals(Winner.PLAYER_TWO, TwoOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
	
	@Test
	public void testPlayerOneWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.ACE));
		hand1.setKickerRank(Rank.JACK);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.ACE));
		hand2.setKickerRank(Rank.NINE);
		assertEquals(Winner.PLAYER_ONE, TwoOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
	@Test
	public void testPlayerTwoWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.TEN));
		hand1.setKickerRank(Rank.JACK);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.TEN));
		hand2.setKickerRank(Rank.KING);
		assertEquals(Winner.PLAYER_TWO, TwoOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
	@Test
	public void testPlayerTie() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.ACE));
		hand1.setKickerRank(Rank.JACK);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.ACE));
		hand2.setKickerRank(Rank.JACK);
		assertEquals(Winner.TIE, TwoOfAKindResolver.SINGLETON.resolve(hand1, hand2));
	}
}
