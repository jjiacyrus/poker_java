package com.game.euler;

import java.util.ArrayList;
import java.util.List;

public class MockHandGenerator implements HandGeneratorInterface {

	private List<String> linesForGenerate;
	private List<TwoHandsInterface> handsToGenerate;

	public MockHandGenerator() {
		handsToGenerate = new ArrayList<TwoHandsInterface>();
	}

	@Override
	public List<TwoHandsInterface> generateHands(List<String> lines) {
		linesForGenerate = lines;
		return handsToGenerate;
	}

	public List<String> getLinesForGenerate() {
		return linesForGenerate;
	}

	public void setHandsToGenerate(List<TwoHandsInterface> handsToReturn) {
		this.handsToGenerate = handsToReturn;
	}

}
