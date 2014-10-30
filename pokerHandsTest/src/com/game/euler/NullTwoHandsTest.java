package com.game.euler;

import static com.TestHelper.assertIsOfInterface;
import static org.junit.Assert.*;

import org.junit.Test;

import com.TestHelper;
import com.model.NullHand;

public class NullTwoHandsTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(TwoHandsInterface.class, NullTwoHands.class);
	}

	@Test
	public void testIsSingleton() throws Exception {
		assertEquals(0, NullTwoHands.class.getConstructors().length);
		TestHelper.assertIsOfTypeAndGet(NullTwoHands.class, NullTwoHands.NULL);
	}

	@Test
	public void testReturnsNullHands() throws Exception {
		assertEquals(NullHand.NULL, NullTwoHands.NULL.getHand1());
		assertEquals(NullHand.NULL, NullTwoHands.NULL.getHand2());
	}
}
