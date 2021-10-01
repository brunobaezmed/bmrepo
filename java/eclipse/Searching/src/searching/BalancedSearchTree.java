package searching;

public class BalancedSearchTree <Key extends Comparable<Key>,Value> {
	
	private Key Key;
	private Value value;
	private BalancedSearchTree<Key,Value> root;
	private BalancedSearchTree<Key,Value> left;
	private BalancedSearchTree<Key,Value> middle;
	private BalancedSearchTree<Key,Value> right;
	private long size;
	
	public BalancedSearchTree() {
		
		this.root=BalancedSearchTree.this;
		this.right=null;
		this.middle=null;
		this.left=null;
		this.size=0;
		
	}
	
	public BalancedSearchTree<Key,Value> insertKey(Key key,Value value) {
		
		if(isEmpty()) {
			
			this.Key=key;
			this.value=value;
			this.size+=1;
			return root;
		}else
			{
			
			
			
			
			
			
			
			
			
			
			
			
		}
		return null;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	
}
