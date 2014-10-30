package com.game.euler;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.game.HandComparator;
import com.game.HandEvaluator;
import com.game.MockHand;
import com.game.MockHandComparator;
import com.game.Winner;

public class EulerEvaluatorTest {

	@Test
	public void testEvaluateFile() throws Exception {

		ArrayList<TwoHandsInterface> handsToGenerate = new ArrayList<TwoHandsInterface>();
		TwoHands hands1 = new TwoHands(new MockHand(), new MockHand());
		TwoHands hands2 = new TwoHands(new MockHand(), new MockHand());
		TwoHands hands3 = new TwoHands(new MockHand(), new MockHand());
		TwoHands hands4 = new TwoHands(new MockHand(), new MockHand());
		handsToGenerate.add(hands1);
		handsToGenerate.add(hands2);
		handsToGenerate.add(hands3);
		handsToGenerate.add(hands4);
		MockHandGenerator mockHandGenerator = new MockHandGenerator();
		mockHandGenerator.setHandsToGenerate(handsToGenerate);

		MockHandComparator comparator = new MockHandComparator();
		comparator.setWinnerForHands(hands1, Winner.PLAYER_TWO);
		comparator.setWinnerForHands(hands2, Winner.PLAYER_ONE);
		comparator.setWinnerForHands(hands3, Winner.TIE);
		comparator.setWinnerForHands(hands4, Winner.TIE);

		EulerEvaluator eulerEvaluator = new EulerEvaluator(mockHandGenerator,
				comparator);

		EulerResults result = eulerEvaluator.evaluateFile(new File(
				"./resources/testEuler.txt"));

		assertEquals(4, mockHandGenerator.getLinesForGenerate().size());
		assertEquals("line1", mockHandGenerator.getLinesForGenerate().get(0));
		assertEquals("line2", mockHandGenerator.getLinesForGenerate().get(1));
		assertEquals("line3", mockHandGenerator.getLinesForGenerate().get(2));
		assertEquals("line4", mockHandGenerator.getLinesForGenerate().get(3));

		assertEquals(1, result.getPlayerOneWins());
		assertEquals(1, result.getPlayerTwoWins());
		assertEquals(2, result.getTies());
	}

	@Test
	public void testIntegrationTest() throws Exception {
		EulerEvaluator eulerEvaluator = new EulerEvaluator(
				new EulerHandGenerator(new EulerLineParser()),
				new HandComparator(new HandEvaluator()));

		EulerResults result = eulerEvaluator.evaluateFile(new File(
				"./resources/euler_hands.txt"));
		assertEquals(376, result.getPlayerOneWins());
		assertEquals(624, result.getPlayerTwoWins());
	}
}
