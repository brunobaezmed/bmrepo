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
		RedBlackTree *r=new RedBlackTree;
	
		*aux=p->right;
		if(*aux!=NULL){
		r->key =p->key;
		r->value = p ->value;
		r->color = p->color;
		r->left= p->left;
		r->root=*aux;

		p->key = (*aux)->key;
		p->value= (*aux)->value;
		p->right = (*aux)->right;
		p->left=r;
			}
		insert(p->key,p->value,p);



	}

	void rot_right(RedBlackTree *p,RedBlackTree *root){

		RedBlackTree **aux=&root;
		RedBlackTree *r=new RedBlackTree;
		if(*aux!=NULL){
		*aux=p->left;
		r->key =p->key;
		r->value = p ->value;
		r->color = p->color;
		r->right= p->right;
		r->root=*aux;

		p->key = (*aux)->key;
		p->value= (*aux)->value;
		p->left = (*aux)->left;
		p->right=r;
		}
		insert(p->key,p->value,p);



	



		

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
				
			}
		else if((node == node->root->left ) &&(node->root == a->right)){
			rot_right(node->root,this);
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
 void postorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" \n";
		inorder(n->left);
		inorder(n->right);

  }

};
int main(){

	 RedBlackTree<char> *tree=new RedBlackTree<char>;	

	 tree->insert(33,'b',tree);
	 tree->insert(5,'m',tree);
	 tree->insert(23,'q',tree);
     tree->insert(50,'r',tree);
	 tree->insert(1,'s',tree);

	 //cout<<tree->right->key<<" "<<tree->right->color;
	 tree->inorder(tree);
	 //tree->postorder(tree);
	 return 0;
}

