#include <iostream>
//Tema1
using namespace std;
int main(){

     int n,c= 0;
     int sum = 0;
     float prom = 0;
     cout<<"Ingrese n"<<"\n";
     cin>>n;
     for( int q = 3; q < n; ++q){

          if(q%3 == 0){
               sum = sum+q;
               c++;
          }

     }
   
     prom = (float)sum/c;
     cout<<"El resultado de la sumatoria es "<<sum<<" y el promedio es "<<prom<<"\n";
     
     return 0;
}