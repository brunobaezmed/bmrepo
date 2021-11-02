#include<iostream>
#include<string>
#include<fstream>
#include<thread>
using namespace std;
template < class type1,class type2>
class RedBlackTree{
	
	enum color_t {BLACK,RED};
	
	  public:
		RedBlackTree *root,*left,*right;
		color_t color=RED;
		type1  key;
		type2 value;
		long size;
		
		RedBlackTree(){
			this->root= nullptr;
			this->left= nullptr ;
			this->right=nullptr;
			this->color=RED;
			this->key=0;
			this->size=0;
			

			
		}
		~RedBlackTree(){
			
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


	
	type2 getValue(RedBlackTree *tree,type1 key){
		if(tree == NULL)
			return NULL;
		if(tree->key == key)
			return tree->value;
		if(tree->key < key)
			return getValue(tree->right,key);
		if(tree->key > key)
			return getValue(tree->left,key);


	}
	RedBlackTree *insertNode(RedBlackTree *n,type1 key,type2 value){
		
		if(n->key == 0){

				n->key=key;
				n->value=value;
				n->root=NULL;
				n->color=RED;
				this->size++;
				return n;
		}
		if(n == NULL)
			return NULL;
		
		if(n->key<key){
			if(n->right == nullptr){
				RedBlackTree *n2 =new RedBlackTree;
				n->right=n2;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				this->size++;
				return n;
				}
			 insertNode(n->right,key,value);
		}
		else if(n->key>key) {
			if(n->left == nullptr){
				
				RedBlackTree *n2 =new RedBlackTree;
				n->left=n2;
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->color=RED;
				this->size++;
				return n;
			}
			 insertNode(n->left,key,value);
		}
		return n;
	}
	void insert(type1 key,type2 value,RedBlackTree *node){
		
		

		insertNode(node,key,value);	
	     RedBlackTree *n=getNode(this,key);
		checkRBT(n->key,n->value,n);
	 
	}

	void checkRBT(type1 key,type2 value,RedBlackTree *node){
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
			node=getNode(node,node->key);
			node=node->left;	
			}
		else if((node == node->root->left ) &&(node->root == a->right)){
			rot_right(node->root,this);
			node=getNode(node,node->key);
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
		postorder(n->left);
		postorder(n->right);

  }

  RedBlackTree *getNode(RedBlackTree *n,type1 key){
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
void t1(RedBlackTree<int,string> *tree){

	 tree->insert(33,"b6",tree);
	 tree->insert(5,"m5",tree);
	 tree->insert(23,"q4",tree);
      tree->insert(55,"r2",tree);
	 tree->insert(98,"Br",tree);
	 tree->insert(11,"c1",tree);
      tree->insert(521,"q514",tree);
      tree->insert(7,"r2",tree);
	 tree->insert(1,"Bruno",tree);
	 tree->insert(20,"c17",tree);
      tree->insert(97,"b1",tree);
}
void t2(RedBlackTree<int,string> *tree){


}
void file(const char path[],RedBlackTree<int,string> *tree){
	char c =' ';
	int n =0 ;
	int m = 0;
	int csize=0;
	ifstream file ;
	file.open(path,std::ifstream::in); 
	while(true){

		while(c!='\n'&&c!=EOF){
			c=file.get();
			n++;
		}
		m++;
		if(n>csize)csize=n;
		if(c == EOF)break;
		n=0;
		c='0';
	}
	n=csize;

	char *list=new char[m*n];

	m=0;
	file.clear();
	file.clear(file.eofbit);
	file.seekg(0,file.beg);
	while(file.good()){
		
		file.getline((list+m*n),15,'\n');
		m++;

	}
	for(int i=0;i<m-1;i++){
		tree->insert(random()+1,(list+m*n),tree);
	}
 	file.close();
};