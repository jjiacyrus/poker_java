package com.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.model.Rank;


public class HandEvaluatorTest {

	@Test
	public void testEvaluateHandStraightFlush() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setIsFlush(true);
		hand.setIsStraight(true);
		
		assertEquals(HandValue.STRAIGHT_FLUSH,evaluator.evaluateHand(hand));		
	}
	
	@Test
	public void testEvaluateHandFourOfAKind() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setFourOfAKindRank(Rank.EIGHT);
		
		assertEquals(HandValue.FOUR_OF_A_KIND,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandFullHouse() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setThreeOfAKindRank(Rank.EIGHT);
		hand.setPairRanks(Arrays.asList(Rank.NINE));
		
		assertEquals(HandValue.FULLHOUSE,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandFlush() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setIsFlush(true);
		hand.setIsStraight(false);
		
		assertEquals(HandValue.FLUSH,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandStraight() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setIsFlush(false);
		hand.setIsStraight(true);
		
		assertEquals(HandValue.STRAIGHT,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandThreeOfAKind() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setThreeOfAKindRank(Rank.ACE);
		hand.setPairRanks(new ArrayList<Rank>());
		
		assertEquals(HandValue.THREE_OF_A_KIND,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandTwoPair() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setPairRanks(Arrays.asList(Rank.EIGHT, Rank.FOUR));
		
		assertEquals(HandValue.TWO_PAIR,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandTwoOfAKind() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		hand.setPairRanks(Arrays.asList(Rank.EIGHT));
		
		assertEquals(HandValue.TWO_OF_A_KIND,evaluator.evaluateHand(hand));
	}
	
	@Test
	public void testEvaluateHandHighCard() throws Exception {
		HandEvaluator evaluator = new HandEvaluator();
		MockHand hand = new MockHand();
		
		assertEquals(HandValue.HIGH_CARD,evaluator.evaluateHand(hand));
	}
}
