#include "TRedBlackTree.h"
using namespace std;
int main(){


	 RedBlackTree<int,string> *tree=new RedBlackTree<int,string>;	
	 std::thread thread1 (t1,tree);
	 std::thread thread2  (file,"/home/bruno",tree);
	 thread1.join();
	 thread2.join();	
	 tree->postorder(tree->root);
	 cout<<"\n"<<tree->size;	
	 
      delete(tree);
	 return 0;
}
