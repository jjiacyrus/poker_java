package com.game;

import com.game.resolver.HandValueResolver;

public interface HandValueInterface {

	public abstract int value();

	public abstract HandValueResolver getTieResolver();

}