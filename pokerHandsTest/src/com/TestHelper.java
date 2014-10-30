package com;

import static org.junit.Assert.*;

import java.util.Arrays;

public class TestHelper {

	@SuppressWarnings("unchecked")
	static public <T> T assertIsOfTypeAndGet(Class<T> expectedClass,
			Object object) {
		assertEquals(expectedClass, object.getClass());
		return (T) object;
	}

	static public <T, U> void assertIsOfInterface(Class<T> expectedInterface,
			Class<U> classUnderTest) {
		assertTrue(
				classUnderTest.getName() + " was not of expected interface "
						+ expectedInterface.getName(),
				Arrays.asList(classUnderTest.getInterfaces()).contains(
						expectedInterface));
	}

}
