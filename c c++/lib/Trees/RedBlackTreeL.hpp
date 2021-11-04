#include <iostream>
#include <thread>
#include <exception>
#define MAX_SIZE 1000
using namespace std;
template < class type1,class type2>
class RedBlackTree{
	
	 enum color_t {BLACK,RED};
	 
public:
	  	struct Node{

			type1 key;
			type2 value;
			Node *left,*right,*root;  
			color_t color=RED;
			};
	 	
		RedBlackTree():root{
			new Node[MAX_SIZE]},
			size{0}{

			for(int i =0 ;i < 9 ;++i){
				(root+i)->key =0;
			
				(root+i)->left =nullptr;
				(root+i)->right =nullptr;
				(root+i)->root = nullptr;
				
				}
			Tsz = 9;
			};

		

		RedBlackTree(int s):root{
			new Node[s]},
			size{0}{
				for(int i =0 ;i < s ;++i){
				(root+i)->key =0;
				(root+i)->left =nullptr;
				(root+i)->right =nullptr;
				(root+i)->root = nullptr;

			}
			Tsz = s;
		};

		~RedBlackTree(){
			delete[] root;
		
		}
private:
		int size;
		Node *root;
		int Tsz ;
public:

   void Rezize()  {
		for(int i = Tsz ;i < Tsz*Tsz/2 ;++i){
			(root+i)->key =0;
			
			(root+i)->left =nullptr;
			(root+i)->right =nullptr;
			(root+i)->root = nullptr;
				
			}
			Tsz= Tsz*Tsz/2;
		
	};


   void rot_left(Node *p){
	   	Node *root = Treeroot();
		Node **aux=&root;

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

	void rot_right(Node *p){

		Node *root=Treeroot();
		Node **aux=&root;
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
	Node *grandpha(Node *n){
		if((n != NULL) && (n->root != NULL))
			return n->root->root;
		else 
			return NULL;
		}
	Node *uncle(Node *n){

		Node *g=grandpha(n);
		if(g!=NULL){
		if(n->root == g->left)
			return g->right;
		else
			return g->left;
		}else return NULL;
		}


	
	type2 getValue(Node *tree,type1 key){
		if(tree == NULL)
			return NULL;
		if(tree->key == key)
			return tree->value;
		if(tree->key < key)
			return getValue(tree->right,key);
		if(tree->key > key)
			return getValue(tree->left,key);


	}
	void insertNode(Node *n,type1 key,type2 value){
	
		if(root->key == 0){
			(root+size)->key = key;
			(root+size)->value = value;
			++size;  
			return;
		};
		if(n->key == key) return;
		if(key > n->key){
			if(n->right == nullptr){
				n->right = (root+size);
				(root+size)->key = key;
				(root+size)->value = value;
				(root+size)->root = n;
				++size;  
				return;
			}
			insertNode(n->right,key,value);
		}
		else if(key < n->key )
		{
			if(n->left == nullptr){
				n->left = (root+size);
				(root+size)->key = key;
				(root+size)->value = value;
				(root+size)->root = n;
				++size;  
				return;
			}
			insertNode(n->left,key,value);
		}

		
	}
	

	void insert(type1 key,type2 value){
		if(this->size >= Tsz){
			Rezize();

		}
		Node *Troot=Treeroot();
		
		insertNode(Troot,key,value);	
		Node *n=getNode(Troot,key);     
		checkRBT(n);
	 
	}

	void checkRBT(Node *node){
			if(node->root == NULL ){
				
			node->color=BLACK;
			return;
			
			}
	 
		
		 if(node->root->color == BLACK)
		 	return;

		Node *un=uncle(node);
		Node *a = grandpha(node);
		if((un !=NULL) && (un->color == RED)){
			node->root->color = BLACK;
			un->color = BLACK;
			a = grandpha(node);
			a->color = RED;
		    checkRBT(a);
		 	return;
			}	
		a=grandpha(node);
		
		if(a!=NULL){

		if((node == node->root->right) && (node->root == a->left)){
			rot_left(node->root);
			node=getNode(node,node->key);
			node=node->left;	
			}
		else if((node == node->root->left ) &&(node->root == a->right)){
			rot_right(node->root);
			node=getNode(node,node->key);
			node=node->right;
			}
		a=grandpha(node);
		
		node->root->color = BLACK;
		a->color = RED;
		if((node == node->root->left) && (node ->root == a->left)){
			rot_right(a);
			
			}
		else{
			rot_left(a);
			}

		}
	}




  void inorder(){
	  Node *n=Treeroot();
	  inorder(n);
  }
  void postorder(){
	  Node *n=Treeroot();
	  postorder(n);
  }
  Node * Treeroot(){
	  Node *n = root;
	  while(n->root != nullptr)
	  n= n->root;
	  return n;
  }
  void inorder(Node *n){

	  	if(n == NULL ) return;
		inorder(n->left);
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" root = ";
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
			}
		else{cout<<"NULL\n";}
		inorder(n->right);

  }
 void postorder(Node *n){

	  	if(n == NULL ) return;
		cout<<n->key<<" value = "<<n->value<<" color= "<<n->color<<" root = ";
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
		}
		else{cout<<"NULL\n";}
		postorder(n->left);
		postorder(n->right);

  }

  Node *getNode(Node *n,type1 key){

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
int sz(){return size;}





};

