package com.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class SuitTest {

	@Test
	public void testIsAnEnum() throws Exception {
		assertTrue(Suit.class.isEnum());
	}
	
	@Test
	public void testFindByAbbreviation() throws Exception
	{
		assertEquals(Suit.DIAMONDS, Suit.findByAbbreviation('D'));
		assertEquals(Suit.HEARTS, Suit.findByAbbreviation('H'));
		assertEquals(Suit.SPADES, Suit.findByAbbreviation('S'));
		assertEquals(Suit.CLUBS, Suit.findByAbbreviation('C'));
		assertEquals(Suit.NULL, Suit.findByAbbreviation('X'));
		assertEquals(Suit.NULL, Suit.findByAbbreviation('B'));
	}
}
