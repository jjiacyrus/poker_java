package com.game.euler;

import java.util.ArrayList;
import java.util.List;

public class EulerHandGenerator implements HandGeneratorInterface {

	private LineParserInterface lineParser;

	public EulerHandGenerator(LineParserInterface lineParser) {
		this.lineParser = lineParser;
	}

	@Override
	public List<TwoHandsInterface> generateHands(List<String> lines) {
		ArrayList<TwoHandsInterface> hands = new ArrayList<TwoHandsInterface>();
		for (String line : lines) {
			hands.add(lineParser.parseLine(line));
		}
		return hands;
	}

	public LineParserInterface getLineParser() {
		return lineParser;
	}

}
