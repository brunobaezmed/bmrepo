package sorting;
//Priority Queue
public class PriorityQueueList<key extends Comparable<key>> {

	private key h;
	private int size;
	private LinkedList<key> list = new LinkedList<key>();

	public PriorityQueueList() {
		this.size = 0;
	}

	public PriorityQueueList(int max) {

		this.size = max;

	}

	public PriorityQueueList(key[] v) {

		while (v.length > size) {

			list.addFirst(v[size], list);

			size += 1;
		}

	}

	public void Insert(key m) {
		list.addFirst(m, list);
		size++;
	}

	public key max() {

		LinkedList<key> node;
		node = list.next(list);
		key max = node.item(node);
		int compare;

		while (node != null) {

			compare = node.item(node).compareTo(max);
			if (compare > 0) {
				max = node.item(node);

			}
			node = node.next(node);

		}

		this.h = max;
		return max;
	}

	public key delMax() {
		h = max();
		list.removeItem(h, list);
		size--;
		return h;
	}

	public Boolean IsEmpty() {

		if (size == 0)
			return true;
		return false;

	}

	public int size() {
		return this.size;

	}
}