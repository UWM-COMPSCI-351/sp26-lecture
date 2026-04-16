package edu.uwm.cs351;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayMap<E> extends AbstractMap<Integer,E> {
	private final E[] data;
	
	public ArrayMap(E[] array) {
		data = array;
	}

	@Override // required
	public Set<Entry<Integer, E>> entrySet() {
		return new EntrySet();
	}

	@Override // implementation
	public E put(Integer key, E value) {
		E oldValue = data[key];
		data[key] = value;
		return oldValue;
	}

	private class EntrySet extends AbstractSet<Entry<Integer,E>> {

		@Override // required
		public Iterator<Entry<Integer, E>> iterator() {
			return new MyIterator();
		}

		@Override // required
		public int size() {
			return data.length;
		}
		
	}
	
	private class MyIterator implements Iterator<Entry<Integer,E>> {

		private int index = -1;
		
		@Override // required
		public boolean hasNext() {
			return index + 1 < data.length;
		}

		@Override // required
		public Entry<Integer, E> next() {
			++index;
			return new Entry<Integer,E>() {

				@Override
				public Integer getKey() {
					return index;
				}

				@Override
				public E getValue() {
					return data[index];
				}

				@Override
				public E setValue(E value) {
					E oldValue = data[index];
					data[index] = value;
					return oldValue;
				}
				
			};
		}
		
	}
}
