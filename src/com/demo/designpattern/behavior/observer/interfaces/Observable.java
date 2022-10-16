package com.demo.designpattern.behavior.observer.interfaces;

import com.demo.designpattern.behavior.observer.classes.ObserverImpl;

public interface Observable<T> {

	public ObserverImpl<T> subscribe(Next<T> n);

	public ObserverImpl<T> subscribe(Next<T> n, Error e);

	public ObserverImpl<T> subscribe(Next<T> n, Error e, Complete c);

	public void next(T data);

	public void error(String error);

	public void complete();

	public void removeSubscription(ObserverImpl<T> observer);

}
