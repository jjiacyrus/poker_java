package com.game.euler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EulerHandGeneratorTest.class, EulerLineParserTest.class, 
		EulerResultsTest.class, NullTwoHandsTest.class, TwoHandsTest.class })
public class TestSuite {

}
