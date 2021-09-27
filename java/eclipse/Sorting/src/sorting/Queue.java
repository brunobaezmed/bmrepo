package sorting;
public class Queue<Item> {

	private int size;
	private Item itemL;

	public Queue() {
		this.size = 0;

	}

	public void push(Item item) {

		this.itemL = item;
		this.size++;

	}

	public Item pop() {

		this.size--;

		return itemL;

	}

	public boolean isEmpty() {
		if (this.itemL == null || size() == -1)
			return true;
		return false;

	}

	public int size() {

		return this.size;
	}
}