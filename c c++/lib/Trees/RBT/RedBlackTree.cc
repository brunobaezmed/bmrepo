#include "RedBlackTreeL.h"
using namespace std;
void test1()
{

	RedBlackTree<int, string> *tree;
	RedBlackTree<int, string> t;
	tree = &t;
	tree->insert(33, "b6");
	tree->insert(5, "m5");
	tree->insert(23, "q4");
	tree->insert(55, "rll2");
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
	tree->delete_key(55);

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
	tree->insert(55, "r2ll");
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
	
	

	tree->inorder();
	cout<<"deleted "<<tree->delete_key(521)<<"\n";
	cout<<"deleted "<<tree->delete_key(5)<<"\n";
	cout<<"deleted "<<tree->delete_key(1)<<"\n";
	cout<<"deleted "<<tree->delete_key(27)<<"\n";
	cout<<"deleted "<<tree->delete_key(20)<<"\n";
	cout<<"deleted "<<tree->delete_key(55)<<"\n";

	tree->inorder();
	cout << tree->sz();
	return ;
}
void test3(){
	

}
int main(int argc,char * argv[] )
{
	int t =0;
	cin>>t;
	switch(t){
		case 1:
			test1();
			break;
		case 2:
			test2();
			break;
		case 3:
			test3();
			break;
		case 4:
			test1();
			test2();
		
	}
	return EXIT_SUCCESS;
}