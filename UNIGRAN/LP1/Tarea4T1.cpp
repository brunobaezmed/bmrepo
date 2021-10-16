#include<iostream>
using namespace std;
int main(){
     
     float prec=0;
     float iva;
     cout<<"Ingrese el precio "<<endl;
     cin>>prec;

     iva=0.1*prec;
     prec=prec+iva;
     cout<<"El precio final es "<<prec<<endl;     

     return 0;
}