package searching;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
public class TestBST {

	public static void main(String[] args) {
		SecureRandom rng=new SecureRandom();
		searching.BinarySearchTree<Long,String> bst=new searching.BinarySearchTree<Long,String>();
		Long t =System.nanoTime();
		List<String> values = null;
		ArrayList<Long>keys=new ArrayList<Long>();
		
		
/*		try {
			values = Files.readAllLines(Path.of("/home/bruno/Documents/java/eclipse/Searching/src/searching/FileSymbol"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		for(String val:values) {
			t=rng.nextLong()%1000;
			keys.add(t);
			bst.insertKey(bst, t, val);
		}

		*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		bst.insertKey(bst, (long) 77, "matias");
		bst.insertKey(bst, (long) 89, "baez");
		bst.insertKey(bst, (long) 23, "medina");
		bst.insertKey(bst, (long) 12, "milanesa");
		bst.insertKey(bst, (long) 35, "asado");
		bst.insertKey(bst, (long) 63, "atun");
		bst.insertKey(bst, (long) 5,"sandwich");
		bst.insertKey(bst, (long) 9,"campera");
		bst.insertKey(bst, (long) 85,"c");
		bst.insertKey(bst, (long) 25, "atun");
		bst.Inorder(bst);
		System.out.print("MaxKey="+bst.removeMax()+" MinKey="+bst.removeMin()+"\n");
		bst.Inorder(bst);
		
		
		
		
		//bst.keymin(bst);
		//bst.keymax(bst);
		/*bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);
		bst.removeMin(bst);*/
		/*bst.Inorder(bst);
		System.out.println();
		t=System.nanoTime();
		bst.removeKey(bst, (long)35);
	
		
		bst.removeKey(bst, (long)55);
		bst.removeKey(bst, (long)63);
		bst.removeKey(bst, (long)23);
		bst.removeKey(bst, (long)89);
		bst.removeKey(bst, (long)85);
	    bst.removeKey(bst,(long) 5);	
		bst.removeKey(bst,(long) 77);
		bst.removeKey(bst,(long) 9);
	
		
	
	
		bst.removeKey(bst, (long)25);
		t=System.nanoTime()-t;
	
			
		JOptionPane.showMessageDialog(null,t, "time(ns) ", JOptionPane.INFORMATION_MESSAGE, null);
		
		System.out.println(bst.size()+" "+bst.keymax(bst)+" "+bst.isEmpty());
		bst.removeKey(bst, (long)12);
		
		System.out.println(bst.size()+" "+bst.keymax(bst)+" "+bst.isEmpty());
		bst.Inorder(bst);
		
		
		/*bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);
		bst.removeMax(bst);*/
	
		
		
		
		//bst.getvalue(bst,(long)35);
		
		//bst.getvalue(bst, (long)55);

	}

}
