package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RankTest {

	@Test
	public void testIsEnum() throws Exception {
		assertTrue(Rank.class.isEnum());
	}

	@Test
	public void testValues() throws Exception {
		assertEquals(-1, Rank.NULL.value());
		assertEquals(2, Rank.TWO.value());
		assertEquals(3, Rank.THREE.value());
		assertEquals(4, Rank.FOUR.value());
		assertEquals(5, Rank.FIVE.value());
		assertEquals(6, Rank.SIX.value());
		assertEquals(7, Rank.SEVEN.value());
		assertEquals(8, Rank.EIGHT.value());
		assertEquals(9, Rank.NINE.value());
		assertEquals(10, Rank.TEN.value());
		assertEquals(11, Rank.JACK.value());
		assertEquals(12, Rank.QUEEN.value());
		assertEquals(13, Rank.KING.value());
		assertEquals(14, Rank.ACE.value());
	}

	@Test
	public void testIsComparable() throws Exception {
		assertEquals(Comparable.class, Rank.class.getInterfaces()[0]);
	}
	
	@Test
	public void testCompare() throws Exception {
		assertEquals(-1, Rank.TWO.compareTo(Rank.THREE));
		assertEquals(1, Rank.THREE.compareTo(Rank.TWO));
		assertEquals(0, Rank.THREE.compareTo(Rank.THREE));
	}
	
	@Test
	public void testFindByAbbreviation() throws Exception{
		assertEquals(Rank.TWO ,Rank.findByAbbreviation('2'));
		assertEquals(Rank.THREE ,Rank.findByAbbreviation('3'));
		assertEquals(Rank.FOUR ,Rank.findByAbbreviation('4'));
		assertEquals(Rank.FIVE ,Rank.findByAbbreviation('5'));
		assertEquals(Rank.SIX ,Rank.findByAbbreviation('6'));
		assertEquals(Rank.SEVEN ,Rank.findByAbbreviation('7'));
		assertEquals(Rank.EIGHT ,Rank.findByAbbreviation('8'));
		assertEquals(Rank.NINE ,Rank.findByAbbreviation('9'));
		assertEquals(Rank.TEN ,Rank.findByAbbreviation('T'));
		assertEquals(Rank.JACK ,Rank.findByAbbreviation('J'));
		assertEquals(Rank.QUEEN ,Rank.findByAbbreviation('Q'));
		assertEquals(Rank.KING ,Rank.findByAbbreviation('K'));
		assertEquals(Rank.ACE ,Rank.findByAbbreviation('A'));
		assertEquals(Rank.NULL ,Rank.findByAbbreviation('Z'));
		assertEquals(Rank.NULL ,Rank.findByAbbreviation('D'));

	}
	
	
}
