package com.demo.designpattern.behavior.observer.interfaces;

@FunctionalInterface
public interface Next<T> {
	public void next(T data);

}
