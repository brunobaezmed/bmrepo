
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
};
void insert(int key,long value,Node *n){

          (troot+tz)->key=key;
          (troot+tz)->value=value;
          (troot+tz)->root=n;
     
          tz++;
     
}

int size(){return tz;}
     

};
void k(){

     ArrayofNodes a;
     a.insert(5,7352,a.troot);
     a.insert(53,421,a.troot);
     a.insert(2,421,a.troot);
     a.insert(1,76575,a.troot);

};
int main(){
   
     k();
}
