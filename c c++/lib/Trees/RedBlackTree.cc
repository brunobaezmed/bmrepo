#include "RedBlackTreeL.hpp"
using namespace std;
void test1()
{

	RedBlackTree<int, string> *tree;
	RedBlackTree<int, string> t;
	tree = &t;
	tree->insert(33, "b6");
	tree->insert(5, "m5");
	tree->insert(23, "q4");
	tree->insert(55, "r2");
	tree->insert(98, "Br");
	tree->insert(11, "c1");
	tree->insert(521, "q514");
	tree->insert(7, "r2");
	tree->insert(1, "no");
	tree->insert(20, "c17");
	tree->insert(2, "uniq");
	tree->insert(15, "Bruno");
	tree->insert(27, "afaf");
	tree->insert(16, "unfdfhdiq");
	tree->insert(19, "AENPGP");
	
	

	tree->postorder();
	cout<<"deleted "<<tree->delete_key(521)<<"\n";
	cout<<"deleted "<<tree->delete_key(5)<<"\n";
	cout<<"deleted "<<tree->delete_key(1)<<"\n";
	cout<<"deleted "<<tree->delete_key(27)<<"\n";
	cout<<"deleted "<<tree->delete_key(20)<<"\n";
		tree->postorder();
	cout << tree->sz();
	return ;
}
void test2()
{

	RedBlackTree<int, string> *tree;
	RedBlackTree<int, string> t;
	tree = &t;
	tree->insert(33, "b6");
	tree->insert(5, "m5");
	tree->insert(23, "q4");
	cout<<"\n";
	


	cout<<"deleted "<<tree->delete_key(33)<<"\n";
	tree->postorder();
	cout<<"\n";
	tree->insert(33, "b6");

	tree->postorder();
	cout << tree->sz();
}
void test3(){
	

}
int main()
{
	test1();
	//
	//test2();

	return 0;
}