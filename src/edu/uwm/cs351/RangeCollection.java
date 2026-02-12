package edu.uwm.cs351;

import java.util.AbstractCollection;
import java.util.Iterator;

public class RangeCollection extends AbstractCollection<Integer> {

	private final int lo, hi;
	
	public RangeCollection(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
	}

	@Override // required
	public int size() {
		return hi-lo;
	}

	@Override // required
	public Iterator<Integer> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Integer> {

		int current = 0;
		
		@Override // required
		public boolean hasNext() {
			return current+1 < hi;
		}

		@Override // required
		public Integer next() {
			return current = current+1;
		}
		
	}
}
