package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Hand implements HandInterface {

	private List<CardInterface> cards;
	private HashMap<Integer, List<Rank>> countToRanks;

	public Hand(CardInterface card1, CardInterface card2, CardInterface card3,
			CardInterface card4, CardInterface card5) {
		List<CardInterface> cards = Arrays.asList(card1, card2, card3, card4,
				card5);
		Collections.sort(cards);
		this.cards = cards;
		countToRanks = createCountRankHash(cards);
	}

	@Override
	public List<CardInterface> getCards() {
		return cards;
	}

	@Override
	public Rank getHighCardRank() {
		return cards.get(4).getRank();
	}

	@Override
	public List<Rank> getPairRanks() {
		if (countToRanks.containsKey(2)) {
			return countToRanks.get(2);
		}
		return new ArrayList<>();
	}

	@Override
	public Rank getThreeOfAKindRank() {
		if (countToRanks.containsKey(3)) {
			return countToRanks.get(3).get(0);
		}
		return Rank.NULL;
	}

	@Override
	public Rank getFourOfAKindRank() {
		if (countToRanks.containsKey(4)) {
			return countToRanks.get(4).get(0);
		}
		return Rank.NULL;
	}

	@Override
	public boolean isStraight() {
		int currentRank = cards.get(0).getRank().value();
		for (int i = 1; i < 5; i++) {
			CardInterface card = cards.get(i);
			if (card.getRank().value() == currentRank + 1) {
				currentRank = card.getRank().value();
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isFlush() {
		Suit suit = cards.get(0).getSuit();
		for (CardInterface card : cards) {
			if (card.getSuit() != suit) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Rank getKickerValue() {
		List<Rank> singleCardValues = countToRanks.get(1);
		return singleCardValues.get(singleCardValues.size() - 1);
	}

	private HashMap<Integer, List<Rank>> createCountRankHash(
			List<CardInterface> cards) {
		HashMap<Rank, Integer> rankToCount = createRankToCountMap(cards);
		HashMap<Integer, List<Rank>> countToRankMap = new HashMap<Integer, List<Rank>>();
		for (Entry<Rank, Integer> entry : rankToCount.entrySet()) {
			Integer count = entry.getValue();
			Rank rank = entry.getKey();
			if (countToRankMap.containsKey(count)) {
				countToRankMap.get(count).add(rank);
				Collections.sort(countToRankMap.get(count));
			} else {
				ArrayList<Rank> list = new ArrayList<Rank>();
				list.add(rank);

				countToRankMap.put(count, list);
			}
		}
		return countToRankMap;
	}

	private HashMap<Rank, Integer> createRankToCountMap(
			List<CardInterface> cards) {
		HashMap<Rank, Integer> rankToCountMap = new HashMap<Rank, Integer>();
		for (CardInterface card : cards) {
			Rank rank = card.getRank();
			if (rankToCountMap.containsKey(rank)) {
				Integer count = rankToCountMap.get(rank);
				rankToCountMap.put(rank, count + 1);
			} else {
				rankToCountMap.put(rank, 1);
			}
		}
		return rankToCountMap;
	}

}
