package com.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RankTest.class, HandTest.class, SuitTest.class, CardTest.class,
		NullHandTest.class, DeckTest.class, NullCardTest.class })
public class TestSuite {

}
