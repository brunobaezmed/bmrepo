#include <iostream>
//Tema4
using namespace std;
int main(){
     int n = 0;
     float s = 1;
     int q = 1;
     cout<<"Ingrese n ";
     cin>>n;
     for(int h = 1;h <= n; h++){
     
          q = q*h;
          s = s+(1/((float)q)); 
          }
     cout<<"S es "<<s;
     cin>>n;
     cout<<" " <<fact(n);
     return 0;
}
