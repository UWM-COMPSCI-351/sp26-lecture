package edu.uwm.cs351;

public class Queue<E> {
	private static final int INITIAL_CAPACITY = 2;
	
	private E[] data;
	private int start, end;
	
	@SuppressWarnings("unchecked") // we know what we are doing
	private E[] makeArray(int cap) {
		return (E[])new Object[cap]; // lying
	}
	
	private void ensureCapacity(int cap) {
		// TODO: NEW!!!!
	}

	public Queue() {
		data = makeArray(INITIAL_CAPACITY);
		start = 0;
		end = data.length - 1;
	}
	
	public int size() {
		int result = end-start + 1;
		// result %= data.length; // circular arithmetic
		if (result >= data.length) result -= data.length;
		else if (result < 0) result += data.length;
		return result;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void enqueue(E element) {
		ensureCapacity(size()+1);
		int newEnd = end + 1;
		if (newEnd == data.length) newEnd = 0;
		data[newEnd] = element;
		end = newEnd;
	}
	
	public E dequeue() {
		E result = data[start];
		++start;
		if (start == data.length) start = 0;
		return result;
	}
	
	public E front() {
		return data[start];
	}
}
