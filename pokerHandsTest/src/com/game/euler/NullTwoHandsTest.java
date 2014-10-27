package com.game.euler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.NullHand;

public class NullTwoHandsTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(TwoHandsInterface.class,
				NullTwoHands.class.getInterfaces()[0]);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullTwoHands.class.getConstructors().length);
		assertEquals(NullTwoHands.class, NullTwoHands.NULL.getClass());
	}

	@Test
	public void testReturnsNullHands() throws Exception {
		assertEquals(NullHand.NULL, NullTwoHands.NULL.getHand1());
		assertEquals(NullHand.NULL, NullTwoHands.NULL.getHand2());
	}
}
