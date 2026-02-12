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

		@Override // required
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override // required
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
