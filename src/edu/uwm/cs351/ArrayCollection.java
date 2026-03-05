package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<T> extends AbstractCollection<T> {
	private static final int INITIAL_CAPACITY = 1;
	
	private T[] data;
	private int used;
	private int version;
	
	@SuppressWarnings("unchecked") // we know what we are doing
	private T[] makeArray(int cap) {
		return (T[])new Object[cap]; // lying
	}
	
	private void ensureCapacity(int cap) {
		if (cap <= data.length) return;
		int newCap = data.length*2;
		if (newCap < cap) newCap = cap;
		T[] newArray = makeArray(newCap);
		for (int i=0; i < used; ++i) {
			newArray[i] = data[i]; 
		}
		data = newArray;
	}
	
	/**
	 * Create an empty array collection.
	 */
	public ArrayCollection() {
		data = makeArray(INITIAL_CAPACITY);
	}
	
	@Override // implementation
	public boolean add(T e) {
		ensureCapacity(used+1);
		data[used] = e;
		++used;
		++version;
		return true;
	}

	@Override // required
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	@Override // required
	public int size() {
		return used;
	}

	private class MyIterator implements Iterator<T> {
		private int index = -1;
		private int colVersion = version;
		
		private void checkVersion() {
			if (version != colVersion) throw new ConcurrentModificationException("stale!");
		}
		
		@Override // required
		public boolean hasNext() {
			checkVersion();
			return index+1 < used;
		}

		@Override //required
		public T next() {
			checkVersion();
			if (!hasNext()) throw new NoSuchElementException("no more");
			++index;
			return data[index];
		}
		
	}
}
