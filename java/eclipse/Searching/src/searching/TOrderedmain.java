package searching;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
public class TOrderedmain {
	
	static final  SecureRandom rng=new SecureRandom();
    
	static Scanner cin = new Scanner(System.in);

	static PrintStream cout = new PrintStream(System.out);

	public static void main(String[] args)throws FileNotFoundException {
	    File f =new File("/home/bruno/Documents/java/eclipse/Searching/src/searching/FileSymbol");
	    Scanner file=new Scanner(f);
	    int p=0;
	    while(file.hasNextLine()) {
	    	p++;
	    	file.nextLine();
	    	
	    }
	    file.close();
	    Scanner file1=new Scanner(f);
		Integer[] k = new Integer[p];
		String[] v = new String[k.length];
		long time=0;

		OrderedSymbolT<Integer, String> Table = new OrderedSymbolT<Integer, String>(k, v);

		
		for (int y = 0; y < k.length; y++) {
			
			cout.print("key:");
			if(y==147)k[y]=40000;
			else k[y] = rng.nextInt(100000);
			
			v[y]=file1.nextLine();
			Table.put(k[y],v[y]);
			
		}
		
		cout.print("\n");
		Table.keys();
		for (int u=0;u<k.length;u++)cout.print(v[u]+"\n");
		time=System.nanoTime();
	
		cout.println(Table.getValue("chip"));
	
	
	
		Table.delete(40000);
		
		time=(System.nanoTime()-time);//(int)Math.pow(10,9);
		cout.print(time);
		

		
		
		cin.close();
		file1.close();
	}

	
	
	
	
	
	
	
	
}