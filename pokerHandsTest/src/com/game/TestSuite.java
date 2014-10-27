package com.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HandComparatorTest.class, HandEvaluatorTest.class,
		HandValueTest.class, WinnerTest.class })
public class TestSuite {

}
