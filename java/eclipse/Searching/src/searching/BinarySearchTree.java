package searching;

import java.util.ArrayList;
import java.util.List;





public class BinarySearchTree<Key extends Comparable<Key>,Value>{

	private final Key c=(Key) "-1";
	private BinarySearchTree<Key,Value> root;
	private BinarySearchTree<Key,Value> left;
	private BinarySearchTree<Key,Value> right;
	private BinarySearchTree<Key,Value>start;
	private Key key;
	private Value value;
	private int size;
	
	public BinarySearchTree() {
		this.start=BinarySearchTree.this;
		this.root=null;
		this.left=null;
		this.right=null;
		
		}
	
	public BinarySearchTree<Key,Value> insertKey(BinarySearchTree<Key,Value> tree,Key key, Value value) {
	  if(isEmpty()) {
		  this.root=null;
		  this.key=key;
		  this.value=value;
		  this.size+=1;
		  
	  	}
	  else {
		  BinarySearchTree<Key,Value> node=tree;
		  	
			  if(key.compareTo(node.key)>0) {
				
				  if(node.right==null) {
		  				BinarySearchTree<Key,Value> n=new BinarySearchTree<Key,Value> ();
		  				n.key=key;
		  				n.value=value;
						node.right=n;
						n.root=node;
						this.size+=1;
						return node;
			
			  							}
				  return insertKey(node.right,key, value);
				
			  }  		
			  else if(key.compareTo(node.key)!=0) {
		
			  
				  if(node.left==null) {
		  				BinarySearchTree<Key,Value> n=new BinarySearchTree<Key,Value> ();
		  				n.key=key;
		  				n.value=value;
		  				node.left=n;
		  				n.root=node;
		  				this.size+=1;
		  				return node;
				  		}
				  return insertKey(node.left,key, value);
			  
			  	}	  	
		  
	  }
	  return tree;
	}

	private BinarySearchTree<Key,Value> getNodeKey(BinarySearchTree<Key,Value> bst,Key key)  {
		
		if(bst==null)return null;
		
		BinarySearchTree<Key,Value> node=bst;
		
			
		
			if(node.key.compareTo(key)==0)return node;
			if(node.key.compareTo(key)>0) {
				return getNodeKey(node.left,key);
			
			}
			else {
			
				return getNodeKey(node.right,key);
			
			}
	
	
		
	
	}

	public Key removeKey(BinarySearchTree<Key,Value> bst,Key key) {
		
		if(bst.size()==1) {
		
			bst.size=0;
			return c;
		}
		BinarySearchTree<Key,Value>node=bst;
		BinarySearchTree<Key,Value>n2=new BinarySearchTree<Key,Value>();
		node=node.getNodeKey(node, key);
		
		Key er=node.key;
		if(node.root==null) {
			
			if(node.right!=null) {
				n2=node.right;
				n2=n2.getNodeKey(n2, n2.keymin(n2));
				node.key=n2.key;
				n2.removeKey(n2, n2.key);
				this.size--;
				return er;
				}
			else
			
				n2=node.left;
				n2=n2.getNodeKey(n2, n2.keymax(n2));
				node.key=n2.key;
				n2.removeKey(n2, n2.key);
				node=n2.left;
				this.size--;
				return er;
			}
		if(node.left==null&&node.right==null) {
			node=node.root;
			if(node.right!=null&&node.right.key.compareTo(key)==0) {
			node.right=null;
			this.size--;
			return er;
			}else { 
				
			node.left=null;
			this.size--;
			return er;
					}
		
			}
		if(node.left!=null&&node.right==null) {
			n2=node;
			node=node.root;
			if(node.right!=null&&node.right.key.compareTo(key)==0) {
			node.right=n2.left;
			n2=n2.left;
			n2.root=node;
			this.size--;
			return er;
			}
			else
			node.left=n2.left;
			n2=n2.left;
			n2.root=node;
			this.size--;
			return er;
							
			}
		if(node.right!=null&&node.left==null) { 
			n2=node;
			node=node.root;
			 if(node.right!=null&&node.right.key.compareTo(key)==0) {

				node.right=n2.right;
				n2=n2.right;
				n2.root=node;
				this.size--;
				return er;
			 }
				else
				node.left=n2.right;
			 	n2=n2.right;
			 	n2.root=node;
			 	this.size--;
				return er;
				
			}
		
		

			n2=node.right;
			n2=n2.getNodeKey(n2, n2.keymin(n2));
			node.key=n2.key;
			n2.removeKey(n2, n2.key);
			this.size--;
			return er;
					
	}

	public Key removeKey(Key key) {
		BinarySearchTree<Key,Value>bst=start;
		if(bst.size()==1) {
		
			bst.size=0;
			return c;
		}
		BinarySearchTree<Key,Value>node=bst;
		BinarySearchTree<Key,Value>n2=new BinarySearchTree<Key,Value>();
		node=node.getNodeKey(node, key);
		
		Key er=node.key;
		if(node.root==null) {
			
			if(node.right!=null) {
				n2=node.right;
				n2=n2.getNodeKey(n2, n2.keymin(n2));
				node.key=n2.key;
				n2.removeKey(n2, n2.key);
				this.size--;
				return er;
				}
			else
			
				n2=node.left;
				n2=n2.getNodeKey(n2, n2.keymax(n2));
				node.key=n2.key;
				n2.removeKey(n2, n2.key);
				node=n2.left;
				this.size--;
				return er;
			}
		if(node.left==null&&node.right==null) {
			node=node.root;
			if(node.right!=null&&node.right.key.compareTo(key)==0) {
			node.right=null;
			this.size--;
			return er;
			}else { 
				
			node.left=null;
			this.size--;
			return er;
					}
		
			}
		if(node.left!=null&&node.right==null) {
			n2=node;
			node=node.root;
			if(node.right!=null&&node.right.key.compareTo(key)==0) {
			node.right=n2.left;
			n2=n2.left;
			n2.root=node;
			this.size--;
			return er;
			}
			else
			node.left=n2.left;
			n2=n2.left;
			n2.root=node;
			this.size--;
			return er;
							
			}
		if(node.right!=null&&node.left==null) { 
			n2=node;
			node=node.root;
			 if(node.right!=null&&node.right.key.compareTo(key)==0) {

				node.right=n2.right;
				n2=n2.right;
				n2.root=node;
				this.size--;
				return er;
			 }
				else
				node.left=n2.right;
			 	n2=n2.right;
			 	n2.root=node;
			 	this.size--;
				return er;
				
			}
		
		

			n2=node.right;
			n2=n2.getNodeKey(n2, n2.keymin(n2));
			node.key=n2.key;
			n2.removeKey(n2, n2.key);
			this.size--;
			return er;
					
	}

	public Value getValue(BinarySearchTree<Key,Value> bst,Key key) {

		BinarySearchTree<Key,Value> node=bst.getNodeKey(bst, key);
		if(node==null)return null;
		//if(node==null)return (Value) c;
		return node.value;

		
	}
	public Key getKey() {
		return this.key;
	}
	
	public Key keymin(BinarySearchTree<Key,Value> bst) {
		BinarySearchTree<Key,Value> node=bst;
		while(node.left!=null)
			node=node.left;
		return node.key;
	}
	
	public Key keymin() {
		BinarySearchTree<Key,Value> node=start;
		while(node.left!=null)
			node=node.left;
		return node.key;
	}


	public Key keymax(BinarySearchTree<Key,Value> bst) {
		BinarySearchTree<Key,Value> node=bst;
		while(node.right!=null)
			node=node.right;
		return node.key;
	}

	

	public Key keymax() {
		BinarySearchTree<Key,Value> node=start;
		while(node.right!=null)
			node=node.right;
		return node.key;
	}
	
	public int size() {
		
		return this.size;
	}

	public boolean isEmpty() {
		return this.size==0 ;
	}

	public int removeMin(BinarySearchTree<Key,Value> bst) {
	
		
		if(bst.size()==1) {
			bst.size--;
			bst.key=null;
			return 1;
		
		}
		BinarySearchTree<Key,Value> node=bst;
		
		while(node.left!=null)
			node=node.left;
		
		if(node.root==null) {
			node=node.right;
			
			bst.key=node.key;
			bst.value=node.value;
			bst.size--;
			bst.right=node.right;
			bst.left=node.left;
			bst.root=null;
			if(node.left!=null)
			node.left.root=bst;
			if(node.right!=null)
			node.right.root=bst;
		
			return 1;
				}
		
		node.root.left=node.right;
		if(node.right!=null)
		node.right.root=node.root;
	
		node=null;	
		this.size--;
		return 1;
	}
	
	public Key removeMin() {
		
		BinarySearchTree<Key,Value> bst=start;
		Key er=bst.key;
		
		if(bst.size()==1) {
			bst.size--;
			bst.key=null;
			return er;
		
		}
		BinarySearchTree<Key,Value> node=bst;
		
		while(node.left!=null)
			node=node.left;
		
		er=node.key;
		if(node.root==null) {
			node=node.right;
			
			bst.key=node.key;
			bst.value=node.value;
			bst.size--;
			bst.right=node.right;
			bst.left=node.left;
			bst.root=null;
			if(node.left!=null)
			node.left.root=bst;
			if(node.right!=null)
			node.right.root=bst;
		
			return er;
				}
		
		node.root.left=node.right;
		if(node.right!=null)
		node.right.root=node.root;
	
		node=null;	
		this.size--;
		return er;
	}
	public int removeMax(BinarySearchTree<Key,Value> bst) {
		
		if(bst.size()==1) {
			bst.size--;
			bst.key=null;
			return 1;
		
		}
		
		BinarySearchTree<Key,Value> node=bst;
		
		while(node.right!=null)
			node=node.right;
		
		
	
		if(node.root==null) {
			node=node.left;
			bst.key=node.key;
			bst.value=node.value;
			bst.size--;
			bst.right=node.right;
			bst.left=node.left;
			bst.root=null;
			if(node.left!=null)
			node.left.root=bst;
			if(node.right!=null)
			node.right.root=bst;
		
			
			return 1;
				}
		
		else {
			
			node.root.right=node.left;
			if(node.left!=null)
			node.left.root=node.root;
			
			node=null;
			this.size--;
			return 1;
		}
	}

	
	
	public Key removeMax() {
		
		
		BinarySearchTree<Key,Value>bst=start;
		Key er=bst.key;
		if(bst.size()==1) {
			bst.size--;
			bst.key=null;
			return er;
		
		}
		
		BinarySearchTree<Key,Value> node=bst;
		
		while(node.right!=null)
			node=node.right;
		
		er=node.key;
		
		if(node.root==null) {
			node=node.left;
			bst.key=node.key;
			bst.value=node.value;
			bst.size--;
			bst.right=node.right;
			bst.left=node.left;
			bst.root=null;
			if(node.left!=null)
			node.left.root=bst;
			if(node.right!=null)
			node.right.root=bst;
		
			
			return er;
				}
		
		else {
			
			node.root.right=node.left;
			if(node.left!=null)
			node.left.root=node.root;
			
			node=null;
			this.size--;
			return er;
		}
	}
	
	
	
	
	

	


	public void Inorder(BinarySearchTree<Key,Value> node) {
		
			if(node==null||isEmpty())return ;
			 Inorder(node.left);
			 System.out.print(node.getKey()+ " value="+node.value+"\n");
			 Inorder(node.right);
	
	}

	private void Inorder(BinarySearchTree<Key,Value> node,List<Key>list) {
		
			if(node==null||isEmpty())return ;
			 Inorder(node.left,list);
			 list.add(node.getKey());
			 Inorder(node.right,list);
	
	}	
	
	public List<Key> ListInorder(BinarySearchTree<Key,Value>node) {
			ArrayList<Key>list=new ArrayList<Key>();
			Inorder(node,list);
			return (list);
			
		
	}
	public void Postorder(BinarySearchTree<Key,Value> node) {
		
		 if(node==null)return ;
		
		
		 Postorder(node.left);
		 
		 Postorder(node.right);
		 System.out.print(node.getKey()+ " ");
		 
}


}
