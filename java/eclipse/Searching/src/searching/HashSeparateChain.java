package searching;

import java.util.Iterator;

import searching.SequencialSearch.Node;

public class HashSeparateChain<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	private int M;
	private SequencialSearch<Key, Value>[] st;
	private SequencialSearch<Key, Value> n;
	private Node keys, ntx;

	public HashSeparateChain() {
		this(998);
	}

	public HashSeparateChain(int M) {
		n = new SequencialSearch<Key, Value>();
		this.M = M;
		ntx = n.new Node();
		st = (SequencialSearch<Key, Value>[]) new SequencialSearch[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequencialSearch();
		}

	}

	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
		keys = n.new Node(key, keys);
		ntx.next = keys;
	}

	private int hash(Key x) {
		return (x.hashCode() & 0x7fffffff) % M;
	}

	public Iterator<Key> iterator() {
		Iterator<Key> i = new Iterator<Key>() {
			public boolean hasNext() {

				if (ntx.next == null) {
					ntx = n.new Node();
					ntx.next = keys;
					return false;
				}
				ntx = ntx.next;

				return ntx != null;

			}

			public Key next() {

				return (Key) ntx.key;
			}

		};
		return i;
	}

	public void delete(Key key) {
		SequencialSearch<Key,Value> sq = st[hash(key)];
		sq.delete(key);
		Node f1 = keys;
		Node q = keys;
		if (f1.key.equals(key)) {
			keys = keys.next;
			ntx.next = keys;
		} else {
			while (f1 != null) {
				if (f1.key.equals(key)) {
					q.next = f1.next;
				}
				q = f1;
				f1 = f1.next;
			}
		}
	}
}
