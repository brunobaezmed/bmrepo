package sorting;
import java.io.PrintStream;
import java.util.Scanner;

public class PQmain {

	static PrintStream cout = new PrintStream(System.out);

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		int b;
		String[] v = new String[g];
		for (int a = 0; a < g; a++)
			v[a] = in.next();

		for (b = 0; b < g; b++)
			cout.printf("v[%d]=%s \n", b + 1, v[b]);
		PriorityQueueArray<String> k = new PriorityQueueArray<String>(v);
		k.Insert("98");
		cout.print(k.Max() + " ");
		k.DelMax();
		cout.print(k.Max());
		cout.print(" keys=" + k.size());
		in.close();
	}

}