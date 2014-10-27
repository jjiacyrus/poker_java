package com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({com.model.TestSuite.class, com.game.resolver.TestSuite.class, com.game.TestSuite.class})
public class AllTests {

}
