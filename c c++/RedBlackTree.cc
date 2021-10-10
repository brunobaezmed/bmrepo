#include<iostream>
using namespace std;
template < class type>
class RedBlackTree{
	//#define NIL = NULL
	enum color_t {BLACK,RED};
	
	  public:
		RedBlackTree *root,*left,*right;
		color_t color;
		long  key;
		type value;



	void rot_left(RedBlackTree *p){
		
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

	void rot_right(RedBlackTree *p){

		RedBlackTree **aux=&root;
		if(p->root!=NULL && p->root->right==p)
			aux=&(p->root->right);
		else if(p->root!= NULL && p->root-left==p)
			aux=&(p->root->right);

		*aux=p->left;
		(*aux)->root=p->root;
		p->left=(*aux)->right;
		(*aux)->right=p;
		if(p->left!= NULL) p->left->root=p;


	}
	RedBlackTree * grandpha(RedBlackTree *n){
		if((n != NULL) && (n->root != NULL))
			return n->root->root;
		else 
			return NULL;
		}
	RedBlackTree * uncle(RedBlackTree *n){

		RedBlackTree *g=grandpha(n);
		if(n->root == n->left)
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
		
		if(n == NULL){

				RedBlackTree *n2=new RedBlackTree;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				return n2;
		}
		
		if(n->key>key){
			if(n->right == NULL){
				RedBlackTree *n2=new RedBlackTree;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				return n2;
				}
			return insertNode(n->right,key,value);
		}
		else if(n->key<key){
			if(n->left== NULL){
				RedBlackTree *n2=new RedBlackTree;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				return n2;
			}
			return insertNode(n->left,key,value);
		}

	}
	void insert(long key,type value,RedBlackTree *tree){
		
		RedBlackTree *node=insertNode(tree,key,value);		
		
		if(tree->root==NULL){
			node->color=BLACK;
			return;
		}
	 
		 if(node->root->color == BLACK)
		 
		 	return;

	
	}
  void inorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		inorder(n->left);
		cout<<n->key<<" value = "<<n->value;
		inorder(n->right);

  }


};
int main(){

	 RedBlackTree<char> *tree=new RedBlackTree<char>;	

	 tree->insert(5,'b',tree);
	 tree->insert(9,'m',tree);
	// cout<<tree->root->key;
	tree->inorder(tree->root);
	 return 0;
}

