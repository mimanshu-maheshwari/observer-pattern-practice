package com.demo.designpattern.behavior.observer.classes;

import com.demo.designpattern.behavior.observer.interfaces.Complete;
import com.demo.designpattern.behavior.observer.interfaces.Next;
import com.demo.designpattern.behavior.observer.interfaces.Observable;
import com.demo.designpattern.behavior.observer.interfaces.Observer;
import com.demo.designpattern.behavior.observer.interfaces.Subscription;
import com.demo.designpattern.behavior.observer.interfaces.Error;

public class ObserverImpl<T> implements Observer<T>, Subscription{

	private Next<T> n;
	private Error e;
	private Complete c;
	private Observable<T> observable;

	private ObserverImpl() {
		super();
		this.n =  x -> {};
	}
	public ObserverImpl(Next<T> n, Observable<T> observable) {
		this();
		this.n = n;
		this.observable = observable;
	}

	public ObserverImpl(Next<T> n, Error e,Observable<T> observable) {
		this();
		this.n = n;
		this.e = e;
		this.observable = observable;
	}

	public ObserverImpl(Next<T> n, Error e, Complete c,Observable<T> observable) {
		this();
		this.n = n;
		this.e = e;
		this.c = c;
		this.observable = observable;
	}

	public Next<T> getN() {
		return n;
	}

	public Error getE() {
		return e;
	}

	public Complete getC() {
		return c;
	}

	public boolean hasN() {
		return this.n != null;
	}

	public boolean hasE() {
		return this.e != null;
	}

	public boolean hasC() {
		return this.c != null;
	}
	
	@Override
	public void unsubscribe() {
		this.observable.removeSubscription(this);
		this.observable = null;
	}
	@Override
	public void complete() {
		this.observable.complete();
	}

}
