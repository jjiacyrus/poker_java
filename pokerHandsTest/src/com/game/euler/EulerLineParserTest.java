package com.game.euler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.Card;
import com.model.CardInterface;
import com.model.Hand;
import com.model.HandInterface;
import com.model.Rank;
import com.model.Suit;

public class EulerLineParserTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(LineParserInterface.class,
				EulerLineParser.class.getInterfaces()[0]);
	}

	@Test
	public void testParseLine() throws Exception {
		String line = "8C TS KC 9H 4S 7D 2S 5D 3S AC";
		EulerLineParser eulerLineParser = new EulerLineParser();
		TwoHandsInterface hands = eulerLineParser.parseLine(line);

		HandInterface hand1 = hands.getHand1();
		HandInterface hand2 = hands.getHand2();

		assertEquals(Hand.class, hand1.getClass());
		assertEquals(Hand.class, hand2.getClass());

		checkCard(Suit.SPADES, Rank.FOUR, hand1.getCards().get(0));
		checkCard(Suit.CLUBS, Rank.EIGHT, hand1.getCards().get(1));
		checkCard(Suit.HEARTS, Rank.NINE, hand1.getCards().get(2));
		checkCard(Suit.SPADES, Rank.TEN, hand1.getCards().get(3));
		checkCard(Suit.CLUBS, Rank.KING, hand1.getCards().get(4));
		
		checkCard(Suit.SPADES, Rank.TWO, hand2.getCards().get(0));
		checkCard(Suit.SPADES, Rank.THREE, hand2.getCards().get(1));
		checkCard(Suit.DIAMONDS, Rank.FIVE, hand2.getCards().get(2));
		checkCard(Suit.DIAMONDS, Rank.SEVEN, hand2.getCards().get(3));
		checkCard(Suit.CLUBS, Rank.ACE, hand2.getCards().get(4));
	}
	
	@Test
	public void testParseLineWhenThereAreNotEnoughCards() throws Exception {
		String line = "8C TS KC 9H 7D 2S 5D 3S AC";
		EulerLineParser eulerLineParser = new EulerLineParser();
		TwoHandsInterface hands = eulerLineParser.parseLine(line);
		assertEquals(NullTwoHands.NULL, hands);
	}
	
	@Test
	public void testParseLineWhenThereAreTooManyCards() throws Exception {
		String line = "8C TS KC 9H 7D 2S 5D 3S AC 5D 8D 9D";
		EulerLineParser eulerLineParser = new EulerLineParser();
		TwoHandsInterface hands = eulerLineParser.parseLine(line);
		assertEquals(NullTwoHands.NULL, hands);
	}
	

	@Test
	public void testUnparseableCardSuit() throws Exception {
		String line = "8C TS KC 9H 4S 7D 2S 5X 3S AC";
		EulerLineParser eulerLineParser = new EulerLineParser();
		TwoHandsInterface hands = eulerLineParser.parseLine(line);
		assertEquals(NullTwoHands.NULL, hands);
	}
	
	@Test
	public void testUnparseableCardRank() throws Exception {
		String line = "8C TS KC 9H 4S 7D 2S VD 3S AC";
		EulerLineParser eulerLineParser = new EulerLineParser();
		TwoHandsInterface hands = eulerLineParser.parseLine(line);
		assertEquals(NullTwoHands.NULL, hands);
	}


	private void checkCard(Suit suit, Rank rank, CardInterface card) {
		assertEquals(new Card(rank, suit), card);
	}
}
