#include <iostream>
//Tema2
using namespace std;
int main(){

     for(int y = 1;y<100 ;y++){
          if(y %3 == 0){

               cout<<"Fizz \n";
          }
           if(y %5 == 0){
               cout<<"Buzz \n";
          }else if( y%3 != 0 && y%5 !=0)
               cout<<y<<"\n";
     }


     return 0;
}
