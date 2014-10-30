package com.game;

import static com.TestHelper.assertIsOfInterface;
import static com.TestHelper.assertIsOfTypeAndGet;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.model.Hand;
import com.model.HandInterface;
import com.model.MockCard;
import com.model.MockDeck;

public class DealerTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(DealerInterface.class, Dealer.class);
	}

	@Test
	public void testDealASingleHand() throws Exception {
		MockDeck deck = new MockDeck();
		MockCard mockCard1 = new MockCard();
		MockCard mockCard2 = new MockCard();
		MockCard mockCard3 = new MockCard();
		MockCard mockCard4 = new MockCard();
		MockCard mockCard5 = new MockCard();
		deck.setCards(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4,
				mockCard5));
		Dealer dealer = new Dealer(deck);

		List<HandInterface> hands = dealer.dealHands(1);
		assertEquals(1, hands.size());

		Hand hand1 = assertIsOfTypeAndGet(Hand.class, hands.get(0));
		assertTrue(hand1.getCards().contains(mockCard1));
		assertTrue(hand1.getCards().contains(mockCard2));
		assertTrue(hand1.getCards().contains(mockCard3));
		assertTrue(hand1.getCards().contains(mockCard4));
		assertTrue(hand1.getCards().contains(mockCard5));
	}

	@Test
	public void testDealTwoHands() throws Exception {
		MockDeck deck = new MockDeck();
		MockCard mockCard1 = new MockCard();
		MockCard mockCard2 = new MockCard();
		MockCard mockCard3 = new MockCard();
		MockCard mockCard4 = new MockCard();
		MockCard mockCard5 = new MockCard();
		MockCard mockCard6 = new MockCard();
		MockCard mockCard7 = new MockCard();
		MockCard mockCard8 = new MockCard();
		MockCard mockCard9 = new MockCard();
		MockCard mockCard10 = new MockCard();
		deck.setCards(Arrays.asList(mockCard1, mockCard2, mockCard3, mockCard4,
				mockCard5, mockCard6, mockCard7, mockCard8, mockCard9,
				mockCard10));
		Dealer dealer = new Dealer(deck);

		List<HandInterface> hands = dealer.dealHands(2);
		assertEquals(2, hands.size());

		Hand hand1 = assertIsOfTypeAndGet(Hand.class, hands.get(0));
		assertTrue(hand1.getCards().contains(mockCard1));
		assertTrue(hand1.getCards().contains(mockCard3));
		assertTrue(hand1.getCards().contains(mockCard5));
		assertTrue(hand1.getCards().contains(mockCard7));
		assertTrue(hand1.getCards().contains(mockCard9));
		
		Hand hand2 = assertIsOfTypeAndGet(Hand.class, hands.get(1));
		assertTrue(hand2.getCards().contains(mockCard2));
		assertTrue(hand2.getCards().contains(mockCard4));
		assertTrue(hand2.getCards().contains(mockCard6));
		assertTrue(hand2.getCards().contains(mockCard8));
		assertTrue(hand2.getCards().contains(mockCard10));
	}
}
