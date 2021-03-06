package sorting;
//mergeLinkedList
import java.io.IOException;
import java.util.Iterator;


public class MergeLinkedList {

	public static void main(String[] args) throws IOException {

		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> node=list;
		SortingInt sort = new SortingInt();

		int listSize = 0, u = 0;
		sort.cout.print("N=");
		String in = sort.cin.readLine();
		listSize = Integer.parseInt(in);

		int[] v = new int[listSize];
		
		list.addEnd(4949, list);
		list.addEnd(17, list);	
		list.addEnd(1501, list);
		list.addEnd(63, list);
		list.addEnd(31, list);
		list.addEnd(23, list);
			
		Iterator<Integer> I=node.iterator(node.next(node));
		
		I.forEachRemaining(node1->node.item(node.next(node)));
		
		for (u = 0; u < listSize; u++) {
			
			list = list.next(list);
			v[u] = list.item(list);
			
		}
			

		sort.sortMergeSort(v);
		sort.PrintVector(v);

	}

}