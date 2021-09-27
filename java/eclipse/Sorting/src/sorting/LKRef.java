package sorting;


//linked list

import java.util.Iterator;



public class LKRef<type> {

	private LKRef<type> next,start;
	private type Item;

	public LKRef() {
		this.start=null;
		this.Item = null;
		this.next = null;

	}

	public void addFirst(type item) {
		LKRef<type> n = new LKRef<type>();
		n.next = start;
		n.Item = item;
		start = n;
	}

	public void printList() {
		LKRef<type> node = start;
		while (node != null) {
			System.out.print(" " + node.Item);
			node = node.next;
		}
	}

	public void removeFirst() {

		LKRef<type> node;
		node = start;
		start= node.next;
		node = null;

	}

	public void addEnd(type item) {

		LKRef<type> node;
		node = start;
		while (node.next != null) {
			node = node.next;
		}

		LKRef<type> n = new LKRef<type>();
		n.Item = item;
		n.next = null;
		node.next = n;

	}

	public void removeItem(type value) {
		boolean found = false;
		LKRef<type> node = start;
		LKRef<type> nr = null;
		if (node.Item.equals(value)) {
			start = node.next;

		} else {
			while (node != null) {

				if (node.Item.equals(value)) {
					nr.next = node.next;
					found = true;
				}
				nr = node;
				node = node.next;

			}
			if (found == false)
				System.out.print("incorrect value\n");
		}

	}

	public type item(LKRef<type> list) {

		return list.Item;
	}

	public LKRef<type> next(LKRef<type> list) {

		return list.next;
	}

	public Iterator<type> iterator(LKRef<type> list) {
		Iterator<type> I=new Iterator<type>(){

			@Override
			public boolean hasNext() {
				return list.next(list)!=null;
			}

			@Override
			public type next() {
				
				return list.item(list.next);
			}
			
			
		
			
				};
		return I;
	}
	public type Item(LKRef<type> list,type item) {
	
		while(list.iterator(list).hasNext()) {
			list=list.next(list);
			if(list.item(list).equals(item)) {
				return list.item(list);
			}
		
		}
		
		return null; 
		
	}
}
