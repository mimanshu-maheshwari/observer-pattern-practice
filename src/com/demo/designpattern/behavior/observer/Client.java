package com.demo.designpattern.behavior.observer;

import com.demo.designpattern.behavior.observer.classes.ObservableImpl;
import com.demo.designpattern.behavior.observer.interfaces.Observable;
import com.demo.designpattern.behavior.observer.interfaces.Subscription;

public class Client {

	public static void main(String[] args) {
		
		Observable<String> stringObservable = new ObservableImpl<String>();
		Observable<Integer> integerObservable = new ObservableImpl<Integer>();
		Subscription s1 = stringObservable.subscribe(System.out::println, System.err::println , () -> {System.out.println("Completed observable of string");});
		Subscription s2 = stringObservable.subscribe(System.out::println, System.err::println , () -> {System.out.println("Completed observable of string");});
		Subscription i1 = integerObservable.subscribe(System.out::println, System.err::println , () -> {System.out.println("Completed observable of string");});
		
		stringObservable.next("this is a string observable 1 emitting 1");
		integerObservable.next(1);
		stringObservable.error("some error occured for string observable");
		stringObservable.complete();
		System.out.println();
		stringObservable.next("this is a string observable 1 emitting 2");
		integerObservable.next(2);
		i1.unsubscribe();
		integerObservable.next(3);
		System.out.println();
	}

}
