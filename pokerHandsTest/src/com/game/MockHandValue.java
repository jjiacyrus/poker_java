package com.game;

import com.game.resolver.HandValueResolver;
import com.game.resolver.MockHandResolver;

public class MockHandValue implements HandValueInterface{

	private MockHandResolver mockResolver;
	private int value;

	public MockHandValue(int value, MockHandResolver mockResolver) {
		this.value = value;
		this.mockResolver = mockResolver;
	}

	@Override
	public int value() {
		return value;
	}

	@Override
	public HandValueResolver getTieResolver() {
		return mockResolver;
	}

}
