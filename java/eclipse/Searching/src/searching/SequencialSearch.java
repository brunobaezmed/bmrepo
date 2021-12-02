package searching;

import java.util.Iterator;

public class SequencialSearch<Key extends Comparable<Key>, Value> {

	private Node first;
	private int size;
	private Node ntx;

	public class Node {
		Key key;
		Value value;
		Node next;

		Node() {

		}

		Node(Key key, Node next) {
			this.key = key;
			this.next = next;
		}

		Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;

		}
	}

	SequencialSearch() {
		this.ntx = new Node();
	}

	public void put(Key key, Value value) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.value = value;
				return;
			}
		first = new Node(key, value, first);
		ntx.next = first;

		size++;

	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.value;

		return null;

	}

	public boolean contains(Key key) {

		return get(key) == null;
	}

	public boolean isEmpty() {
		return size == 0;// true if isEmpty false otherwise
	}

	public int size() {
		return this.size;
	}

	public Iterator<Key> keys() {
		Iterator<Key> i = new Iterator<Key>() {
			public boolean hasNext() {

				if (ntx.next == null) {
					ntx = new Node();
					ntx.next = first;
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
		Node f1 = first;
		Node q = first;
		if (f1.key.equals(key)) {
			first = first.next;
			ntx.next = first;
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
