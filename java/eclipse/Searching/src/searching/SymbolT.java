package searching;
import java.util.Arrays;
import java.util.Iterator;


public class SymbolT<Key extends Comparable<Key>, Value> implements SymbolTableInterface<Key, Value>, Iterable<Key> {

	private Key[] key;
	private Value[] value;
	private int size;
	private int curr;
	public SymbolT(Key m[], Value v[]) {// create a symbol table
		super();
		key = m;
		value = v;
		this.curr=0;
	}

	public void put(Key key, Value value) {// put key-value pair into the table

		if (value == null)
			delete(key);

		else {

			for (int q = 0; q < this.size; q++)

				if (key.compareTo(this.key[q]) == 0) {
					this.value[q] = value;
					return;

					
				}

			this.size++;
			this.key[this.size - 1] = key;
			this.value[this.size - 1] = value;
		}

	}

	public Value get(Key key) {

		int q;
		for (q = 0; q < this.size; q++)
			if (key.compareTo(this.key[q]) == 0)
				return this.value[q];
				return null;
	}
	public Iterator<Key> iterator(){
		
		Iterator<Key> I=new Iterator<Key>() {	

		public boolean hasNext() {
			
			if(curr<size)
				return true;
				return false;
				}
		
		public Key next(){	
			return key[curr++];
				}
					
			};
		return I;
	}
	
	
	public void delete(Key key) {

		int q;

		for (q = 0; q < this.size; q++)
			if (key.compareTo(this.key[q]) == 0) {
				this.key[q] = null; 
				
				}

		this.size--;
	}

	public boolean contains(Key key) {

		
				return get(key)==null;
	}

	public boolean isEmpty() {
		return key[0] == null && size == 0;// true if isEmpty false otherwise
	}

	public int size() {
		return this.size;
	}

	public  Iterable<Key> keys() {
	
		Arrays.sort(key);
		while(iterator().hasNext()) {
			System.out.print(iterator().next()+"\n");
			}
			return null;
		}


	

}
