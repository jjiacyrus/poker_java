package com.game.resolver;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.game.MockHand;
import com.game.Winner;
import com.model.Rank;

public class TwoPairResolverTest {

	@Test
	public void testExtendsHandValueResolver() throws Exception {
		assertEquals(HandValueResolver.class,
				TwoPairResolver.class.getSuperclass());
	}
	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, TwoPairResolver.class.getConstructors().length);
		assertEquals(TwoPairResolver.class, TwoPairResolver.SINGLETON.getClass());
	}
	
	@Test
	public void testPlayerOneWins_HighPair() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.ACE));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.JACK));
		
		assertEquals(Winner.PLAYER_ONE, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
	
	@Test
	public void testPlayerTwoWins_HighPair() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.TEN));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.JACK));
		
		assertEquals(Winner.PLAYER_TWO, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}

	
	@Test
	public void testPlayerOneWins_LowPair() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.NINE, Rank.ACE));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.ACE));
		
		assertEquals(Winner.PLAYER_ONE, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
	
	@Test
	public void testPlayerTwoWins_LowPair() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.TEN));
		
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.NINE, Rank.TEN));
		
		assertEquals(Winner.PLAYER_TWO, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
	

	@Test
	public void testPlayerOneWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.NINE, Rank.ACE));
		hand1.setKickerRank(Rank.KING);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.NINE, Rank.ACE));
		hand2.setKickerRank(Rank.NINE);
		assertEquals(Winner.PLAYER_ONE, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
	
	@Test
	public void testPlayerTwoWins_Kicker() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.NINE, Rank.TEN));
		hand1.setKickerRank(Rank.KING);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.NINE, Rank.TEN));
		hand2.setKickerRank(Rank.ACE);
		assertEquals(Winner.PLAYER_TWO, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
	
	@Test
	public void testTie() throws Exception {
		MockHand hand1 = new MockHand();
		hand1.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.TEN));
		hand1.setKickerRank(Rank.KING);
		MockHand hand2 = new MockHand();
		hand2.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.TEN));
		hand2.setKickerRank(Rank.KING);
		assertEquals(Winner.TIE, TwoPairResolver.SINGLETON.resolve(hand1, hand2));
	}
}
