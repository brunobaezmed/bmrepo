package searching;

import java.io.PrintStream;
import java.util.Scanner;

public class THashTable {
	static Scanner cin = new Scanner(System.in);
	static PrintStream cout = new PrintStream(System.out);
	
	public static void main(String args[])  {
		HashSeparateChain<Double,String> hs = new HashSeparateChain<Double,String>();
		
		hs.put((double) 66, "b");
		hs.put((double) 114, "r");
		hs.put((double) 117, "u");
		hs.put((double) 110, "n");
		hs.put((double) 111, "o");
		hs.put((double)85, "U");
		hs.put((double)78, "N");
		hs.put((double)73, "I");
		hs.put((double)81, "Q");
		hs.put((double)69, "E");

		
		while(hs.iterator().hasNext()) {
			cout.print(hs.iterator().next()+" ");
		}
	

	
		cout.println();
		while(hs.iterator().hasNext()) {
			cout.print(hs.iterator().next()+" ");
		}

	}
	
}
