package sorting;
//tsorting
import java.io.IOException;
import java.util.Arrays;

public class tsorting {

	public static void main(String[] args) throws IOException {

		SortingInt sort = new SortingInt();
		int n = 0;

		sort.cout.println("n:");// stdout.println("n:");
		String s = new String(sort.cin.readLine());
		n = Integer.parseInt(s);

		int v[] = new int[n];
		int c[] = new int[n];

		for (int m = 0; m < n; m++)
			v[m] = sort.rng.nextInt(10000);

		System.arraycopy(v, 0, c, 0, v.length);
		c = sort.sortInsertion(c);
		sort.cout.printf("Insertion=%f ", sort.getTimer() / Math.pow(10, 3));

		System.arraycopy(v, 0, c, 0, v.length);
		c = sort.sortSelection(c);
		sort.cout.printf("Selection=%f ", sort.getTimer() / Math.pow(10, 3));

		System.arraycopy(v, 0, c, 0, v.length);
		c = sort.sortBubble(c);
		sort.cout.printf("Bubble=%f ", sort.getTimer() / Math.pow(10, 3));

		System.arraycopy(v, 0, c, 0, v.length);
		sort.sortMergeSort(c);
		sort.cout.printf("MergeSort=%f ", sort.getTimer() / Math.pow(10, 3));

		System.arraycopy(v, 0, c, 0, v.length);
		sort.sortQuickSort(c);

		sort.cout.printf("QuickSort=%f ", sort.getTimer() / Math.pow(10, 3));
		System.arraycopy(v, 0, c, 0, v.length);
		long t = System.currentTimeMillis();
		Arrays.sort(c);
		t = System.currentTimeMillis() - t;
		sort.setTimer((double) t);
		sort.cout.printf("util.ArraysSort=%f ", sort.getTimer() / Math.pow(10, 3));

		System.arraycopy(v, 0, c, 0, v.length);
		c = sort.sortHeapsort(c);
		sort.cout.printf("HeapSort=%f ", sort.getTimer() / Math.pow(10, 3));

	}
}