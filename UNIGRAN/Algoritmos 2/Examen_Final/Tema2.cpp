#include <iostream>
#include <cstring>
#include <cstdlib>
#include <ctime>

using namespace std;
void imprimir_vector(int [] );
int main(){
     srand(time(NULL));

     int v[20];
     int q = 0;

     while(q < 20){
          v[q] = rand()%50+1;
          q++;
     }
     cout<<"Vector inicial ";
     imprimir_vector(v);

     for(q = 0; q < 20 ; q++){
          if(v[q]%2 ==0 &&q %2 != 0){
          
               v[q] = v[q]*-1;
          }          
          if(v[q]%2 ==0 &&q %2 == 0){
               v[q] = v[q]+100;    
          }
          if(v[q]%2 !=0 &&q %2 == 0){
               v[q] = v[q]*100;    

          }
     }
     cout<<"\nVector salida ";
     imprimir_vector(v);
     
     
     system("PAUSE");
     return 0;
}
void imprimir_vector(int v[]){
     cout<<"V[]= ";
     for(int q = 0 ;q < 20; q++){
          cout<<v[q]<<" ";
     }
};
