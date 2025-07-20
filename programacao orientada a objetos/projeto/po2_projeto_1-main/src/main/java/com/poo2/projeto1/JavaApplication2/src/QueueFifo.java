package com.poo2.projeto1;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * 
 * @author Vitor Emanuel
 *
 * @param <T>
 */
public class QueueFifo<T> implements Iterable<T>{
	private ArrayDeque<T> arr;
	public QueueFifo() {
		this.arr = new ArrayDeque<T>();
		// TODO Auto-generated constructor stub
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.arr.iterator();
	}
	
	public void push(T t) {
		this.arr.add(t);
	}
	public int size() {
		return this.arr.size();
	}
	public T pop() {
		return this.arr.removeFirst();
	}
	
	public boolean isEmpty() {
		return this.arr.isEmpty();
	}
	
	
	
}
