#include "RedBlackTreeL.hpp"
using namespace std;
void test1(){

	 RedBlackTree<int,string> *tree;
	 RedBlackTree<int,string> t;
	 tree = &t;
	 tree->insert(33,"b6");
	 tree->insert(5,"m5");
	 tree->insert(23,"q4");
      tree->insert(55,"r2");
	 tree->insert(98,"Br");
	 tree->insert(11,"c1");
      tree->insert(521,"q514");
      tree->insert(7,"r2");
	 tree->insert(1,"no");
	 tree->insert(20,"c17");
      tree->insert(2,"uniq");
	 tree->insert(15,"Bruno");
	 tree->insert(27,"afaf");
      tree->insert(16,"unfdfhdiq");
	 tree->insert(19,"AKFNIONFOIQNOFQNIEONGIOENIGIOENGQ3PGP");
	
	 tree->postorder();
	 cout<<tree->sz();
}
void test2(){

	 RedBlackTree<int,string> *tree;
	 RedBlackTree<int,string> t;
	 tree = &t;
	 tree->insert(33,"b6");
	 tree->insert(5,"m5");
	 tree->insert(23,"q4");
      tree->insert(55,"r2");
	 tree->insert(98,"Br");
	 tree->insert(11,"c1");
      tree->insert(521,"q514");
      tree->insert(7,"r2");
	 tree->insert(1,"no");
	 tree->insert(20,"c17");
      tree->insert(2,"uniq");
	 tree->insert(15,"Bruno");
	 tree->insert(27,"afaf");
      tree->insert(16,"unfdfhdiq");
	 tree->insert(19,"AKFNIONFOIQNOFQNIEONGIOENIGIOENGQ3PGP");
	 tree->postorder();
	 cout<<tree->sz();
	
}
int main(){

	
	 test1();
	 test2();
	 
	 return 0;
}