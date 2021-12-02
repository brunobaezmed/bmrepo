package searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class TSequencialSearch {
	static PrintStream cout = new PrintStream(System.out);
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		SequencialSearch<Integer,String> sq = new SequencialSearch<Integer,String>();
		
		sq.put(77, 	"L");
		sq.put(105, "i");
		sq.put(110, "n");
		sq.put(117, "u");
		sq.put(120, "x");		
		while(sq.keys().hasNext()) {
			cout.print(sq.keys().next()+ " ");
		}
		
		

	}
}
