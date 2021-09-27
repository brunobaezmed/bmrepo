package sorting;

public class Bag<Item> {

	private Item item;
	private int size = 0;

	public Bag() {

	}

	public void add(Item item) {

		this.item = item;
		this.size++;

	}

	public boolean isEmpty() {
		if (this.item == null)
			return true;
		return false;

	}

	public int size() {
		return this.size;
	}

}