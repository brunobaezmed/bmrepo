package sorting;
import java.io.PrintStream;

public class mainmaxPQ {
	static PrintStream cout = new PrintStream(System.out);

	public static void main(String[] args) {

		MaxPQ<Double> PQ = new MaxPQ<Double>(5);

		PQ.Insert(22.7);
		PQ.Insert(33.5);
		PQ.Insert(7.7);
		PQ.Insert(78.70);
		PQ.Insert(2.0);
		cout.print("size " + PQ.size());
		cout.print(" max value " + PQ.Max());

		PQ.DelMax();

		cout.printf("\tnew max value %f", PQ.Max());
	}
}
