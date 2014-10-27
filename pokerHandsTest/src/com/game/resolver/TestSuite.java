package com.game.resolver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FourOfAKindResolverTest.class, FullHouseResolverTest.class,
		HighCardResolverTest.class, ThreeOfAKindResolverTest.class,
		TwoOfAKindResolverTest.class, TwoPairResolverTest.class })
public class TestSuite {

}
