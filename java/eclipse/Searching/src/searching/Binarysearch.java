package searching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Binarysearch {
	  
	 
	  public Binarysearch() {
		  
		  super();
	  }
	  
	  public int binarySearch(int v[],int number,int low,int high,int calls) {// 1 5 9 11 15 22 33 55 57 98
			
		  	if(v[(low+high)/2]==number||calls>v.length) {System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  	
		  	if(calls>v.length) {System.out.printf("number not found");}else{System.out.printf("number founded");};
		  	return -1;
		  	}
			
		  	else {
		  		if(v[(low+high)/2]<number) {
		  			System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  			return binarySearch(v,number,(high+low)/2,high,calls+1);
		  			
		  		}
		  		if(v[(low+high)/2]>number) {
		  			
		  			System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  			return binarySearch(v,number,low,(high+low)/2,calls+1);
		  			
		  		}			
		  	}
		  	
		  	return -1;
		}
	  public String binarySearch(String v[],String value,int low,int high,int calls) {// 1 5 9 11 15 22 33 55 57 98
			
		  	if(v[(low+high)/2].equals(value)||calls>v.length) {System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  	
		  	if(calls>v.length) {System.out.printf("value not found");}else{System.out.printf("value founded");};
		  	return v[(low+high)/2];
		  	}
			
		  	else {
		  		if(v[(low+high)/2].compareTo(value)<0) {
		  			System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  			return binarySearch(v,value,(high+low)/2,high,calls+1);
		  			
		  		}
		  		else {
		  			
		  			System.out.printf("low=%d high=%d calls %d \n",low,high,calls);
		  			return binarySearch(v,value,low,(high+low)/2,calls+1);
		  			
		  		}			
		  	}
		
		}
	  
	  
	  
	  
	  
	  
	  public int[] IntFread(BufferedReader f,int n)throws IOException{
		  String a="";
		  
		  int i=0;
		  	  
		  int v[]=new int [n];
		  try {
		  a=f.readLine();
		  while(a!=null) {
			v[i]=Integer.parseInt(a);
			a=f.readLine();
		  	i=i+1;
		  		}
		  f.close();
		  return v;
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  throw new IOException();
		  	
		
	  }
	  public String[] Fread(BufferedReader f,int n)throws IOException {
		  
		  String r="";
		  String []v=new String[n];
		  int y=0;
		  r=f.readLine();
		  while(r!=null) {
			  v[y]=r;
			  r=f.readLine();		  
			  y+=1;
			  
		  }
		  return v;
		  
	  }
	  
	  
	  
	  public int NLinesread(BufferedReader f) throws IOException{
		  int n=0;
		  try {
		  f.mark(1000000);
		  String a=f.readLine();
		  
		  
		  while(a!=null) {
			  a=f.readLine();
			  n++;
		  		}
		  f.reset();
		  return n;
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  throw new IOException();
	  }
	   public FileReader filereader(File file) throws FileNotFoundException{
		  
		   try {
			  FileReader Freader=new FileReader(file);
			  return Freader;
		   }catch(FileNotFoundException e) {
			   e.printStackTrace();
		   }
		  throw new FileNotFoundException();
	  }
	  
	  
	  
}
