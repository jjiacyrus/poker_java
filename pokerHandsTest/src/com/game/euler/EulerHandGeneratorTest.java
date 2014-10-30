package com.game.euler;

import static org.junit.Assert.assertEquals;
import static com.TestHelper.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EulerHandGeneratorTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertIsOfInterface(HandGeneratorInterface.class,
				EulerHandGenerator.class);
	}

	@Test
	public void testGetConstructorArgs() throws Exception {
		MockLineParser parser = new MockLineParser();
		EulerHandGenerator handGenerator = new EulerHandGenerator(parser);
		assertEquals(parser, handGenerator.getLineParser());
	}

	@Test
	public void testGenerateHands() throws Exception {
		MockLineParser parser = new MockLineParser();
		EulerHandGenerator handGenerator = new EulerHandGenerator(parser);
		String line1 = "Line4";
		String line2 = "Line4";
		String line3 = "Line4";
		String line4 = "Line4";
		List<String> lines = Arrays.asList(line1, line2, line3, line4);

		MockTwoHands hands1 = new MockTwoHands();
		MockTwoHands hands2 = new MockTwoHands();
		MockTwoHands hands3 = new MockTwoHands();
		MockTwoHands hands4 = new MockTwoHands();

		parser.setHandsToReturnForLine(line1, hands1);
		parser.setHandsToReturnForLine(line2, hands2);
		parser.setHandsToReturnForLine(line3, hands3);
		parser.setHandsToReturnForLine(line4, hands4);

		List<TwoHandsInterface> generatedHands = handGenerator
				.generateHands(lines);

		assertEquals(4, generatedHands.size());
	}
}
