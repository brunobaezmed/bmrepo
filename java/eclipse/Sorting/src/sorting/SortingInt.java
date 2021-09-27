package sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;

public class SortingInt{

	BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	private double timer;
	PrintStream cout = new PrintStream(System.out);
	SecureRandom rng = new SecureRandom();

	public SortingInt() {
		super();

	}

	public int[] sortHeapsort(int m[]) {

		long t = System.currentTimeMillis();
		int size = m.length;
		int z[] = new int[size + 1];

		for (int g = 0; g < size; g++)
			z[g + 1] = m[g];

		for (int r = size / 2; r >= 1; r--)
			swingMinus(z, r, size);

		while (size > 1) {

			change(z, 1, size--);
			swingMinus(z, 1, size);
		}

		size = m.length;

		for (int l = 0; l < size; l++)
			m[l] = z[l + 1];

		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	private void swingMinus(int z[], int u, int size) {

		while (2 * u <= size) {

			int q = 2 * u;
			if (q < size && z[q] < z[q + 1])
				q++;
			if (z[q] < z[u])
				break;
			change(z, u, q);
			u = q;

		}

	}

	private void change(int m[], int size, int q) {
		int exchange = m[q];
		m[q] = m[size];
		m[size] = exchange;
	}

	public int[] sortBubble(int m[]) {
		long t = System.currentTimeMillis();
		int flag = 0;
		int size = m.length;
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size - 1; j++) {
				if (m[j] > m[j + 1]) {

					flag = m[j + 1];
					m[j + 1] = m[j];
					m[j] = flag;

				}

			}

		}
		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	public int[] sortSelection(int m[]) {
		long t = System.currentTimeMillis();
		int flag = 0, curr = 0;
		int size = m.length;
		for (int i = 0; i < size; i++) {

			curr = i;
			for (int j = i + 1; j < size; j++) {

				if (m[j] < m[curr]) {

					curr = j;
				}

			}
			flag = m[i];
			m[i] = m[curr];
			m[curr] = flag;
		}
		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	public int[] sortInsertion(int m[]) {
		long t = System.currentTimeMillis();
		int size = m.length;

		int max = 0, j = 0, i = 0;
		for (i = 1; i < size; i++) {
			max = m[i];
			for (j = i - 1; j >= 0 && m[j] > max; j--) {
				m[j + 1] = m[j];
			}
			m[j + 1] = max;

		}

		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	public int[] sortMergeSort(int m[]) {
		long t = System.currentTimeMillis();
		int v[] = new int[m.length];

		MergeSort(m, 0, m.length - 1, v);
		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	public void MergeSort(int m[], int left, int right, int v[]) {
		if (left >= right)
			return;
		int md = left + (right - left) / 2;
		MergeSort(m, left, md, v);
		MergeSort(m, md + 1, right, v);
		Merge(m, left, right, md, v);

	}

	private void Merge(int m[], int left, int right, int md, int v[]) {// 1 4 5 7 0 2 3

		int i = left;
		int j = md + 1;

		for (i = left; i <= right; i++) {
			v[i] = m[i];
		}

		for (i = left; i <= right; i++)
			if (left > md) {
				m[i] = v[j];
				j++;
			} else if (j > right) {
				m[i] = v[left];
				left++;
			} else if (v[left] > v[j]) {
				m[i] = v[j];
				j++;
			} else {
				m[i] = v[left];
				left++;
			}

	}

	public int[] sortQuickSort(int m[]) {

		long t = System.currentTimeMillis();
		int size = m.length;
		QuickSort(m, 0, size - 1);
		t = System.currentTimeMillis() - t;
		setTimer((double) t);
		return m;
	}

	private void QuickSort(int m[], int low, int high) {
		if (low >= high)
			return;
		int q = Partition(m, low, high);
		QuickSort(m, low, q - 1);
		QuickSort(m, q + 1, high);
	}

	private int Partition(int m[], int low, int high) {
		int q = m[high];
		int i = low;
		int flag = 0;
		for (int j = low; j < high; j++) {

			if (m[j] < q) {
				flag = m[j];
				m[j] = m[i];
				m[i] = flag;
				i++;
			}

		}
		flag = m[i];
		m[i] = m[high];
		m[high] = flag;
		return i;
	}

	public void PrintVector(int m[]) {
		int size = m.length;
		cout.printf("\n");
		for (int b = 0; b < size; b++) {

			cout.printf("%d ", m[b]);
		}
		cout.printf("\n");

	}

	public double getTimer() {

		return this.timer;
	}

	public void setTimer(double timer) {

		this.timer = timer;
	}

}
