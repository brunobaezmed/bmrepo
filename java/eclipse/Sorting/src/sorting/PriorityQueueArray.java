package sorting;
public class PriorityQueueArray<key extends Comparable<key>> {

	private key k;
	private int size;
	private key[] V;

	public PriorityQueueArray() {
		this.size = 0;
	}

	public PriorityQueueArray(int n) {

		this.size = n;

	}

	public PriorityQueueArray(key[] v) {
		int n = v.length;
		V = v;
		for (int u = 0; u < n; u++)
			V[u] = v[u];
		this.size = n;
	}

	public void Insert(key m) {
		key[] q = (key[]) new Comparable[V.length + 1];
		this.size++;
		int r = 0;
		for (r = 0; r < V.length; r++) {
			q[r] = V[r];

		}
		q[r] = m;
		V = q;

	}

	public key Max() {
		int b = 0;
		int compare = 0;
		key max = V[0];
		for (b = 0; b < V.length; b++) {
			compare = max.compareTo(V[b]);
			if (compare < 0)
				max = V[b];

		}
		this.k = max;
		return max;
	}

	public void DelMax() {

		this.size = V.length - 1;
		int r = 0;
		key[] e = (key[]) new Comparable[V.length - 1];
		for (r = 0; r < V.length - 1; r++) {

			if (!V[r].equals(this.k))
				e[r] = V[r];

		}

		V = e;
	}

	public boolean IsEmpty() {
		if (this.size == 0)
			return true;
		return false;

	}

	public int size() {
		return this.size;
	}

}
