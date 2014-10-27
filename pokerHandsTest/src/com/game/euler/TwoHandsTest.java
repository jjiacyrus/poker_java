package com.game.euler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.MockHand;


public class TwoHandsTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(TwoHandsInterface.class, TwoHands.class.getInterfaces()[0]);
	}
	@Test
	public void testConstructor() throws Exception {
		MockHand hand1 = new MockHand();
		MockHand hand2 = new MockHand();
		TwoHandsInterface twoHands = new TwoHands(hand1, hand2);
		assertEquals(hand1, twoHands.getHand1());
		assertEquals(hand2, twoHands.getHand2());
	}
}
