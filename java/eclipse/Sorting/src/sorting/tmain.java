package sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class tmain {

	static PrintStream cout = new PrintStream(System.out);
	static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException {

		int m = 0;
		String q = "";
		boolean k = false;
		
			
		Queue<String> queue = new Queue<String>();// {()})
		Queue<String> queue2=new Queue<String>();
		if (queue.isEmpty()) {
			q = cin.readLine();
			m = q.length();
		}
		char h[] = q.toCharArray();
		String[] f = new String[m];
		String[] l =new String[m];
		
		while (queue.size() < m) {

			f[queue.size()] = String.valueOf(h[queue.size()]);
			queue.push(f[queue.size()]);
			
		}
			
		cout.print("queue= ");
		
		
		queue.pop();
		while(!queue.isEmpty()||queue.size()!=0) {
			
			
			l[queue2.size()]=f[queue.size()];
			cout.print(l[queue2.size()]);
			queue.pop();
			cout.print(f[queue.size()]+queue2.size());
			
			if(f[queue.size()].equals("{")) {
						
				while(!queue2.isEmpty()||k==false) {
					
					
					if(l[queue2.size()].equals("}")) {
						k=true;
						l[queue2.size()]="-1";
							}
				
					queue2.pop();
					
						}
				if(k==false)break;
					}
				
			
			
					
			
			
			
			if(f[queue.size()].equals("(")) {
				
				while(!queue2.isEmpty()||k==false) {
					
					
					if(l[queue2.size()].equals(")")) {
					k=true;
					l[queue2.size()]="-1";	
						}
					queue2.pop();
					}
				
				if(k==false)break;
			
				}	

			
			
			if(f[queue.size()].equals("[")) {
					
				while(!queue2.isEmpty()||k==false) {
					
					
					if(l[queue2.size()].equals("]")) {
					k=true;
					l[queue2.size()]="-1";
						}
					queue2.pop();
					}
				
				if(k==false)break;
			
				}	
			
			
			
			
		    queue2.push(f[queue.size()]);

			queue.pop();
			}
			
		// {()})
			cout.print(k);

	}

}