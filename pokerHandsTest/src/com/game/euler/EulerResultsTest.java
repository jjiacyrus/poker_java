package com.game.euler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.Winner;

public class EulerResultsTest {

	@Test
	public void testGets() throws Exception {
		EulerResults results = new EulerResults();
		assertEquals(0, results.getPlayerOneWins());
		assertEquals(0, results.getPlayerTwoWins());
		assertEquals(0, results.getTies());
	}
	
	@Test
	public void testAddResult() throws Exception {
		EulerResults results = new EulerResults();
		results.addResult(Winner.PLAYER_ONE);
		
		assertEquals(1, results.getPlayerOneWins());
		assertEquals(0, results.getPlayerTwoWins());
		assertEquals(0, results.getTies());
		
		results.addResult(Winner.PLAYER_TWO);
		assertEquals(1, results.getPlayerOneWins());
		assertEquals(1, results.getPlayerTwoWins());
		assertEquals(0, results.getTies());
		
		results.addResult(Winner.TIE);
		assertEquals(1, results.getPlayerOneWins());
		assertEquals(1, results.getPlayerTwoWins());
		assertEquals(1, results.getTies());
		
		results.addResult(Winner.TIE);
		assertEquals(1, results.getPlayerOneWins());
		assertEquals(1, results.getPlayerTwoWins());
		assertEquals(2, results.getTies());
	}
}
