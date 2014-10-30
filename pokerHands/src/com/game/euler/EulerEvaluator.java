package com.game.euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.game.HandComparatorInterface;
import com.game.Winner;

public class EulerEvaluator {

	private HandGeneratorInterface handGenerator;
	private HandComparatorInterface handComparator;

	public EulerEvaluator(HandGeneratorInterface handGenerator,
			HandComparatorInterface handComparator) {
		this.handGenerator = handGenerator;
		this.handComparator = handComparator;
	}

	public EulerResults evaluateFile(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		List<String> lines = bufferedReader.lines()
				.collect(Collectors.toList());
		List<TwoHandsInterface> hands = handGenerator.generateHands(lines);
		bufferedReader.close();
		EulerResults eulerResults = new EulerResults();

		for (TwoHandsInterface twoHands : hands) {
			Winner winner = handComparator.determineWinner(twoHands);
			eulerResults.addResult(winner);
		}
		return eulerResults;
	}

}
