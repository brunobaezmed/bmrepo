#include<iostream>
#include<string>
#include<fstream>
#include<thread>
using namespace std;
template < class type1,class type2>
class RedBlackTree{
	//#define NIL = NULL
	enum color_t {BLACK,RED};
	
	  public:
		RedBlackTree *root,*left,*right;
		color_t color=RED;
		type1  key;
		type2 value;
		long size;
		
		
			RedBlackTree(){
			this->root=NULL;
			this->left=NULL;
			this->right=NULL;
			this->color=RED;
			this->key=0;
			this->size=0;
			
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
	void insertNode(RedBlackTree *n,type1 key,type2 value){
		
		if(n->key == NULL){

				n->key=key;
				n->value=value;
				n->root=NULL;
				n->color=RED;
				this->size++;
			
				return ;
		}
		if(n->key==key)
			return ;
		
		if(n->key<key){
			if(n->right == NULL){
				RedBlackTree *n2=new RedBlackTree<type1,type2>();
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->left=NULL;
				n2->right=NULL;
				n2->color=RED;
				n->right=n2;
				this->size++;
				return ;
				}
			 insertNode(n->right,key,value);
		}
		else if(n->key>key) {
			if(n->left== NULL){
				RedBlackTree *n2=new RedBlackTree<type1,type2>();
				n2->key=key;
				n2->value=value;
				n2->root=n;
				n2->left=NULL;
				n2->right=NULL;
				n2->color=RED;
				n->left=n2;
				this->size++;
				return ;
			}
			 insertNode(n->left,key,value);
		}
		return;
	}



	void insertN(RedBlackTree *n,type1 key,type2 value){
	
		if(n->key == NULL){

				n->key=key;
				n->value=value;
				n->root=NULL;
				n->color=RED;
				this->size++;
			
				return ;
		}
		RedBlackTree *nw=new RedBlackTree<type1,type2>();
		nw->key=key;
		nw->value=value;
		nw->left=NULL;
		nw->right=NULL;
		nw->color=RED;
		this->size++;

		RedBlackTree *node=new RedBlackTree<type1,type2>();
		RedBlackTree *root=this;
		while(root!=NULL){
			node=root;
			if(nw->key<root->key)
			root=root->left;
			else
			root=root->right;
				
		}
		nw->root=node;
		if(nw->key<node->key)
			node->left=nw;
		else node->right=nw;
	}








	void insert(type1 key,type2 value,RedBlackTree *node){
		
		insertN(node,key,value);	
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
		RedBlackTree *a=grandpha(node);
		if((un !=NULL) && (un->color == RED)){
			node->root->color = BLACK;
			un->color = BLACK;
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
		cout<<n->key<<" value = "<<n->value<<" color= ";
		if(n->color==1){
		cout<<"RED"<<" root = ";
		}

		else{
		cout<<"BLACK"<<" root = ";
		}
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
			}
		else{cout<<"NULL\n";}
		inorder(n->right);

  }
 void postorder(RedBlackTree *n){

	  	if(n == NULL ) return;
		cout<<n->key<<" value = "<<n->value<<" color= ";
		if(n->color==1){
		cout<<"RED"<<" root = ";
		}

		else{
		cout<<"BLACK"<<" root = ";
		}
		if(n->root!=NULL){
		cout<<n->root->key<<" \n";
		}
		else{cout<<"NULL\n";}
		inorder(n->left);
		inorder(n->right);

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
 type1 keymin(){
	 RedBlackTree *q=this->root;
	 while(q->left!=NULL)
		q=q->left;
	  return q->key;
	 
 }
  
 type1 keymax(){
	  RedBlackTree *q=this->root;
	 while(q->right!=NULL)
		q=q->right;
	return q->key;
	 
 }
};


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



int main(){

	
	

	 RedBlackTree<int,string> *tree=new RedBlackTree<int,string>;	
	 /*std::thread first(&RedBlackTree<int,string>::file,tree	,"FileSymbol");
	 std::thread second(&RedBlackTree<int,string>::file,tree,"FileSymbol2");
	 first.join();
	 second.join();*/
	 tree->insert(33,"b6",tree);
	 tree->insert(5,"m5",tree);
	 tree->insert(23,"q4",tree);
      tree->insert(55,"r2",tree);
	 tree->insert(98,"Br",tree);
	 tree->insert(11,"c1",tree);
	 tree->insert(2,"mat",tree);
	 tree->insert(31,"b1",tree);
      tree->insert(7,"p7",tree);
	// file("FileSymbol",tree);
    //  tree->inorder(tree->root);
	 tree->postorder(tree->root);
	  
	  
	//  cout<<tree->keymin()<<endl;
	//  cout<<tree->keymax()<<"\n\n";
	//  tree->inorder(tree->root);
	  cout<<"\n"<<tree->size;
	  delete(tree);
	 return 0;
}
