package searching;

import java.io.PrintStream;
import java.util.Arrays;

import sorting.LinkedList;

import java.io.*;


public class TestBinarySearch {
	
  static PrintStream cout=new PrintStream(System.out);
   
  public static void main(String []args) throws IOException {
	  
	  int n=0;	
	 
      
	  Binarysearch B=new Binarysearch();
	  FileReader Read=B.filereader(new File("/home/bruno/Documents/java/eclipse/Searching/src/searching/FileSymbol"));  
	  BufferedReader BRead=new BufferedReader(Read);	
	  
	  LinkedList<String> list =new LinkedList<String> ();
	  LinkedList<String> slist=list;
	  
	  
	  
	  
	  
	  n=B.NLinesread(BRead);
	  String []e=B.Fread(BRead, n);
	  String []v=Arrays.copyOf(e, e.length);
	  
	  
	  for(int h=0;h<v.length;h++)
		  list.addEnd(v[h], list);
	  
	  	  long time=System.nanoTime();
	  
	  Arrays.sort(v);

	  
	//  B.binarySearch(v,"chip",0,v.length,0);
	  //time=System.nanoTime()-time;
	 // cout.print(" "+time);
	  
	  time=System.nanoTime();
	  String f=slist.Item(slist,"bruno");
	  time=System.nanoTime()-time;
	  cout.print(f+" "+time+" ");
	
	  
	  
	  
	  time=System.nanoTime();
	  Arrays.sort(v);

	  
	  B.binarySearch(v,"bruno",0,v.length,0);
	  time=System.nanoTime()-time;
	  cout.print(" "+time);
	 

	  
	  
	  
	  
	  
	  
	  
  }

	
			
}
