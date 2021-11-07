
#include <iostream>
#include <exception>

enum color_t {RED,BLACK};
using namespace std;
struct Node{

			int key;
			long value;
			Node *left,*right,*root;  
               color_t color = RED;
			};
class ArrayofNodes{
     	
public:


 Node *troot;
 int tz;

          
ArrayofNodes(){
               
			 troot = new Node[7];
                tz =0;

};
~ArrayofNodes(){
     delete[]troot;
};
void insert(int key,long value,Node *n){

          (troot+tz)->key=key;
          (troot+tz)->value=value;
          (troot+tz)->root=n;
     
          tz++;
     

}
 void newnode(int n)    {
      delete[]troot;
      troot = new Node[n];
};

int size(){return tz;}
     

};
void k(){
     ArrayofNodes h;
     h.newnode(5);
     h.newnode(7);
     

};
int main(){
   
     k();
}
