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
		if(p->right != NULL ) p->right->root=p;

	}

	void rot_right(RedBlackTree *p,RedBlackTree *root){

		RedBlackTree **aux=&root;
		RedBlackTree *r=root;
		if(p->root!=NULL && p->root->right==p)
			aux=&(p->root->right);
		else if(p->root!= NULL && p->root->left== p)
			aux=&(p->root->left);

		*aux=p->left;
		(*aux)->root=p->root;
		p->root=*aux;
		p->left=(*aux)->right;
		(*aux)->right=p;

		r->right=root;
		r->root=root->root;
		r->key=root->key;
		r->value=root->value;
		
		
		r->left=root->left;
		
		r->color=root->color;
		//if(p->left!= NULL) p->left->root=p;


	}
	RedBlackTree *grandpha(RedBlackTree *n){
		if((n != NULL) && (n->root != NULL))
			return n->root->root;
		else 
			return NULL;
		}
	RedBlackTree *uncle(RedBlackTree *n){

		RedBlackTree *g=grandpha(n);
		if(n->root == g->left)
			return g->right;
		else
			return g->left;
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
				return n2;
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
		
				return n2;
			}
			return insertNode(n->left,key,value);
		}
	
	}
	void insert(long key,type value,RedBlackTree *node){
		
		node=insertNode(node,key,value);	
		if(node->root == NULL ){
				
			node->color=BLACK;
			return;
			
		}
	 
		
		 if(node->root->color == BLACK)
		 	return;

		RedBlackTree *un=uncle(node);
		RedBlackTree *a;
		if((un !=NULL) && (un->color == RED)){
			node->root->color = BLACK;
			un->color = BLACK;
			a = grandpha(node);
			a->color = RED;
		    insert(a->key,a->value,a);
		 
			}	
		a=grandpha(node);
		if((node == node->root->right) && (node->root == a->left)){
			rot_left(node->root,this);
			node=node->left;
				
			}
		else if((node == node->root->left ) &&(node->root == a->right)){
			rot_right(node->root,this);
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


	 
	}
  void inorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		inorder(n->left);
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" \n";
		inorder(n->right);

  }


};
int main(){

	 RedBlackTree<char> *tree=new RedBlackTree<char>;	

	 tree->insert(33,'b',tree);
	 tree->insert(5,'m',tree);
	 tree->insert(23,'q',tree);
     //tree->insert(37,'r',tree);
	//cout<<tree->left->key;
	tree->inorder(tree);
	 
	 return 0;
}

