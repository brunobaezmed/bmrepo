package searching;
public interface SymbolTableInterface<Key, Value> extends Iterable<Key> {

	public void put(Key Key, Value value);// put the key on the table remove it if null

	public Value get(Key key);// get the value of the key

	public void delete(Key key); // remove key and value

	public boolean contains(Key key);

	public boolean isEmpty();

	public int size();
	

	public Iterable<Key> keys();


}