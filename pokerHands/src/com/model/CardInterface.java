package com.model;

public interface CardInterface extends Comparable<CardInterface> {

	public abstract Suit getSuit();

	public abstract Rank getRank();

}
