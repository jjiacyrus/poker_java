package com.game.euler;

import java.util.ArrayList;

import com.model.Card;
import com.model.CardInterface;
import com.model.Hand;
import com.model.Rank;
import com.model.Suit;

public class EulerLineParser implements LineParserInterface {

	@Override
	public TwoHandsInterface parseLine(String line) {
		String[] split = line.split(" ");
		ArrayList<CardInterface> cards = new ArrayList<CardInterface>();
		for (String string : split) {
			Rank rank = Rank.findByAbbreviation(string.charAt(0));
			Suit suit = Suit.findByAbbreviation(string.charAt(1));
			if (rank.equals(Rank.NULL) || suit.equals(Suit.NULL)) {
				return NullTwoHands.NULL;
			}
			cards.add(new Card(rank, suit));
		}
		if (cards.size() == 10) {
			Hand hand1 = new Hand(cards.get(0), cards.get(1), cards.get(2),
					cards.get(3), cards.get(4));
			Hand hand2 = new Hand(cards.get(5), cards.get(6), cards.get(7),
					cards.get(8), cards.get(9));
			return new TwoHands(hand1, hand2);
		}
		return NullTwoHands.NULL;
	}

}
