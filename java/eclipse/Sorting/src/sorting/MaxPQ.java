package sorting;
public class MaxPQ<key extends Comparable<key>> {

	private key[] V;
	private int size = 0;
	private key max;

	public MaxPQ(int maxV) {

		V = (key[]) new Comparable[maxV + 1];
	}

	public boolean IsEmpty() {

		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public key Max() {
		return this.max;
	}

	public void Insert(key m) {
		V[this.size + 1] = m;
		this.size++;
		swingLarge(this.size);
		max = V[1];
	}

	private void swingLarge(int size) {//
		key exchange;
		while (size > 1 && ((V[size / 2].compareTo(V[size])) < 0)) {

			exchange = V[size / 2];
			V[size / 2] = V[size];
			V[size] = exchange;
			size = size / 2;
		}
	}

	public key DelMax() {

		key max = V[1];
		change(1, this.size--);
		V[this.size + 1] = null;
		swingMinus(1);

		this.max = V[1];
		return max;
	}

	private void swingMinus(int size) {

		while (2 * size <= this.size) {
			int q = 2 * size;

			if (q < this.size && ((V[q].compareTo(V[q + 1])) < 0))
				q++;
			if (V[q].compareTo(V[size]) < 0)
				break;
			change(size, q);
			size = q;
		}
	}

	private void change(int size, int q) {
		key exchange = V[q];
		V[q] = V[size];
		V[size] = exchange;
	}

}
