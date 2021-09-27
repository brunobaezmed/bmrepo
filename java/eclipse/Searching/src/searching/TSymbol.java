package searching;

import java.io.PrintStream;
import java.util.Scanner;

public class TSymbol {

	static Scanner cin = new Scanner(System.in);
	static PrintStream cout = new PrintStream(System.out);

	public static void main(String[] args) {

		Integer[] k = new Integer[5];
		String[] v = new String[k.length];
		SymbolT<Integer, String> Table = new SymbolT<Integer, String>(k, v);

		
		for (int y = 0; y < k.length; y++) {
			
			cout.print("key:");
			k[y] = cin.nextInt();
			cout.print("Value:");
			Table.put(k[y], cin.next());
			
		}
		
		cout.print("size:"+Table.size() + "\n Key=");
		cout.print("Value: "+Table.get(cin.nextInt())+"\n");
		Table.keys();
		cin.close();
	}

}
