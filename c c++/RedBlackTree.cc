#include<iostream>
using namespace std;
template < class type>
class RedBlackTree{
	//#define NIL = NULL
	enum color_t {BLACK,RED};
	
	  public:
		RedBlackTree *root,*left,*right;
		color_t color=RED;
		long  key;
		type value;
		long size;
		
		RedBlackTree(){
			this->root=NULL;
			this->left=NULL;
			this->right=NULL;
			this->color=RED;
			this->key=NULL;
			this->size=NULL;
			
		}


	void rot_left(RedBlackTree *p,RedBlackTree *root){
	
		RedBlackTree **aux=&root;

    if(p->root!=NULL && p->root->right==p)
        aux=&(p->root->right);
    else if(p->root!=NULL && p->root->left==p)
        aux=&(p->root->left);

    	*aux=p->right;
    	(*aux)->root=p->root;
   		 p->root=*aux;
   		 p->right=(*aux)->left;
   		 (*aux)->left=p;

  	  	if(p->right!=NULL) p->right->root=p;
			
		
	}

	void rot_right(RedBlackTree *p,RedBlackTree *root){

		RedBlackTree **aux=&root;
    	if(p->root!=NULL && p->root->right==p)
        aux=&(p->root->right);
    	else if(p->root!=NULL && p->root->left==p)
        aux=&(p->root->left);

    	*aux=p->left;
   	 (*aux)->root=p->root;
    	p->root=*aux;
    	p->left=(*aux)->right;
    	(*aux)->right=p;

  	  if(p->left!=NULL) p->left->root=p;
		


	



		



	}
	RedBlackTree *grandpha(RedBlackTree *n){
		if((n != NULL) && (n->root != NULL))
			return n->root->root;
		else 
			return NULL;
		}
	RedBlackTree *uncle(RedBlackTree *n){

		RedBlackTree *g=grandpha(n);
		if(g!=NULL){
		if(n->root == g->left)
			return g->right;
		else
			return g->left;
		}else return NULL;
		}


	
	type getValue(RedBlackTree *tree,long key){
		if(tree == NULL)
			return NULL;
		if(tree->key == key)
			return tree->value;
		if(tree->key < key)
			return getValue(tree->right,key);
		if(tree->key > key)
			return getValue(tree->left,key);


	}
	RedBlackTree *insertNode(RedBlackTree *n,long key,type value){
		
		if(n->key == NULL){

				n->key=key;
				n->value=value;
				n->root=NULL;
				n->color=RED;
				return n;
		}
		if(n->key==key)
			return n;
		
		if(n->key<key){
			if(n->right == NULL){
				RedBlackTree *n2=new RedBlackTree;
				n->right=n2;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				return n;
				}
			return insertNode(n->right,key,value);
		}
		else if(n->key>key) {
			if(n->left== NULL){
				RedBlackTree *n2=new RedBlackTree;
				n->left=n2;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
		
				return n;
			}
			return insertNode(n->left,key,value);
		}
	
	}
	void insert(long key,type value,RedBlackTree *node){
		
		insertNode(node,key,value);	
	    node=getNode(this,key);
		checkRBT(node->key,node->value,node);
	 
	}

	void checkRBT(long key,type value,RedBlackTree *node){
			if(node->root == NULL ){
				
			node->color=BLACK;
			return;
			
			}
	 
		
		 if(node->root->color == BLACK)
		 	return;

		RedBlackTree *un=uncle(node);
		RedBlackTree *a=new RedBlackTree;
		if((un !=NULL) && (un->color == RED)){
			node->root->color = BLACK;
			un->color = BLACK;
			a = grandpha(node);
			a->color = RED;
		    checkRBT(key,value,this);
		 
			}	
		a=grandpha(node);
		
		if(a!=NULL){

		if((node == node->root->right) && (node->root == a->left)){
			rot_left(node->root,this);
			node=getNode(this,node->key);
			node=node->left;	
			}
		else if((node == node->root->left ) &&(node->root == a->right)){
			rot_right(node->root,this);
			node=getNode(this,node->key);
			node=node->right;
			}
		a=grandpha(node);
		
		node->root->color = BLACK;
		a->color = RED;
		if((node == node->root->left) && (node ->root == a->left)){
			rot_right(a,this);
			
			}
		else{
			rot_left(a,this);
			}

		//checkRBT(key,value,this);
		}
	}





  void inorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		inorder(n->left);
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" root = ";
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
			}
		else{cout<<"NULL\n";}
		inorder(n->right);

  }
 void postorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" root = ";
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
		}
		else{cout<<"NULL\n";}
		inorder(n->left);
		inorder(n->right);

  }

  RedBlackTree *getNode(RedBlackTree *n,type key){
	  if(n ->key == key){
		  return n;
	  }
	  if(n->key>key){
		  return getNode(n->left,key);
	  }
	  if(n->key<key){
		  return getNode(n->right,key);
		
	  }
	  
		return NULL;

  }

};
int main(){

	 RedBlackTree<char> *tree=new RedBlackTree<char>;	

	 tree->insert(33,'b',tree);
	 tree->insert(5,'m',tree);
	 tree->insert(23,'q',tree);
      tree->insert(55,'r',tree);
	  tree->insert(98,'B',tree);
	  tree->insert(11,'c',tree);
      cout<<"n "<<tree->root->right->key<<endl;
	 ///tree->inorder(tree);
	 tree->postorder(tree->root);
	 return 0;
}
