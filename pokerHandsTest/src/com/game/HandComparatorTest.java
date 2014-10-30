package com.game;

import static org.junit.Assert.assertEquals;
import static com.TestHelper.*;

import org.junit.Test;

import com.game.euler.TwoHands;
import com.game.resolver.MockHandResolver;

public class HandComparatorTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(HandComparatorInterface.class, HandComparator.class);
	}

	@Test
	public void testConstructedWithHandEvaluator() throws Exception {
		MockHandEvaluator handEvaluator = new MockHandEvaluator();
		HandComparator handComparator = new HandComparator(handEvaluator);

		assertEquals(handEvaluator, handComparator.getEvaluator());
	}

	@Test
	public void testDetermineWinner_PlayerOne() throws Exception {
		MockHandEvaluator handEvaluator = new MockHandEvaluator();
		HandComparator handComparator = new HandComparator(handEvaluator);

		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();
		handEvaluator.setHandValue(hand1, HandValue.FULLHOUSE);
		handEvaluator.setHandValue(hand2, HandValue.TWO_OF_A_KIND);

		assertEquals(Winner.PLAYER_ONE,
				handComparator.determineWinner(new TwoHands(hand1, hand2)));
	}

	@Test
	public void testDetermineWinner_PlayerTwo() throws Exception {
		MockHandEvaluator handEvaluator = new MockHandEvaluator();
		HandComparator handComparator = new HandComparator(handEvaluator);

		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();
		handEvaluator.setHandValue(hand1, HandValue.FULLHOUSE);
		handEvaluator.setHandValue(hand2, HandValue.STRAIGHT_FLUSH);

		assertEquals(Winner.PLAYER_TWO,
				handComparator.determineWinner(new TwoHands(hand1, hand2)));
	}

	@Test
	public void testDetermineWinner_SameHandValueWillResolveUsingTieResolverOfThatRank()
			throws Exception {
		MockHandEvaluator handEvaluator = new MockHandEvaluator();
		HandComparator handComparator = new HandComparator(handEvaluator);

		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();

		MockHandResolver mockResolver = new MockHandResolver();
		MockHandValue mockHandValue = new MockHandValue(1, mockResolver);

		handEvaluator.setHandValue(hand1, mockHandValue);
		handEvaluator.setHandValue(hand2, mockHandValue);

		mockResolver.setWinnerToReturn(Winner.PLAYER_TWO);
		assertEquals(Winner.PLAYER_TWO,
				handComparator.determineWinner(new TwoHands(hand1, hand2)));
		assertEquals(hand1, mockResolver.getHand1ToResolve());
		assertEquals(hand2, mockResolver.getHand2ToResolve());
	}
}
