package com.model;

import java.util.List;

public interface DeckInterface {

	public List<CardInterface> getAllCards();

	public CardInterface dealCard();
}
