package searching;

public interface BinarySearchTreeInterface<Key extends Comparable <Key>,Value> {
	
	
	public void insertKey(Key key,Value value);
	public void removeKey(Key key);
	public Value getvalue(Key key);
	public Key keymin();
	public Key keymax();
	public int size();
	public boolean isEmpty();
	public Key removeMin();
	public Key removeMax();
	
}
