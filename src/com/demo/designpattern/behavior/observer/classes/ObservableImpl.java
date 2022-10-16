package com.demo.designpattern.behavior.observer.classes;

import java.util.ArrayList;
import java.util.List;

import com.demo.designpattern.behavior.observer.interfaces.Complete;
import com.demo.designpattern.behavior.observer.interfaces.Error;
import com.demo.designpattern.behavior.observer.interfaces.Next;
import com.demo.designpattern.behavior.observer.interfaces.Observable;

public class ObservableImpl<T>  implements Observable<T> {
	
	List<ObserverImpl<T>> observers;
	
	public ObservableImpl() {
		this.observers = new ArrayList<>();
	}


	@Override
	public ObserverImpl<T> subscribe(Next<T> n) {
		 ObserverImpl<T> observerImpl = new ObserverImpl<T>(n, this);
		this.observers.add(observerImpl );	
		return  observerImpl;
	}

	@Override
	public ObserverImpl<T>  subscribe(Next<T> n, Error e) {
		ObserverImpl<T> observerImpl =new ObserverImpl<T>(n ,e, this);
		this.observers.add(observerImpl );	
		return  observerImpl;
		
	}

	@Override
	public ObserverImpl<T>  subscribe(Next<T> n, Error e, Complete c) {
		ObserverImpl<T> observerImpl =new ObserverImpl<T>(n, e, c, this);
		this.observers.add(observerImpl );	
		return  observerImpl;
		
	}
	
	private void notifyAllObserversForNext(T data ) {
		observers.forEach(x -> {
			if(x.hasN()) x.getN().next(data);
		});
	}



	private void notifyAllObserversForError(String error) {
		observers.forEach(x -> {
			if(x.hasE()) x.getE().error(error);
		});
		
	}



	private void notifyAllObserversForComplete() {
		for(int i = observers.size() - 1; i >= 0; --i) {
			if(observers.get(i).hasC()) {
				observers.get(i).getC().complete();
			}
			observers.remove(i);
		}
		
	}


	@Override
	public void next(T data) {
		this.notifyAllObserversForNext(data);
		
	}


	@Override
	public void error(String error) {
		this.notifyAllObserversForError(error);
		
	}


	@Override
	public void complete() {
		this.notifyAllObserversForComplete();
		
	}


	@Override
	public void removeSubscription(ObserverImpl<T> observer) {
		this.observers.remove(observer);		
	}
	
	

}
