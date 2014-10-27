package com.game.euler;

import java.util.HashMap;

public class MockLineParser implements LineParserInterface {
	private HashMap<String, TwoHandsInterface> linesToHands;

	public MockLineParser() {
		this.linesToHands = new HashMap<String, TwoHandsInterface>();
	}

	@Override
	public TwoHandsInterface parseLine(String line) {
		if (linesToHands.containsKey(line)) {
			return linesToHands.get(line);
		}
		return NullTwoHands.NULL;
	}
	
	public void setHandsToReturnForLine(String line, TwoHandsInterface hands){
		this.linesToHands.put(line, hands);
	}

}
