package sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.SecureRandom;
public class tmain1 {
	static final SecureRandom rng = new SecureRandom();
	static PrintStream cout = new PrintStream(System.out);
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		LinkedList<Integer> list = new LinkedList<Integer>();

		int a=0;
		

		for (int r = 0; r < 5; r++) {
			a = rng.nextInt(6883);
			list.addFirst(a, list);
		}
		list.printList(list);

		cout.println();

		list.addEnd(21, list);
		list.printList(list);

		cout.println();
		list.removeItem(22, list);
		list.printList(list);

	}

}