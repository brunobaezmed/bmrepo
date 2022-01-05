#include <iostream>
//Tema3
using namespace std;
int main(){

     int n = 0;
     int sueldo  = 0;
     int mayor = 0;
     int menor = 0;
     int s_bruto = 0;
     cout<<"Ingrese la cantidad de empleados\n";
     cin>>n;
     for (int q = 0 ;q < n; ++q){

          cout<<"Ingrese el sueldo del "<<q+1<<" empleado ";
          cin>>sueldo;
          s_bruto = sueldo-0.09*sueldo-0.16*sueldo;
          cout<<"Sueldo de "<<q+1<<"="<<s_bruto<<"\n";
          if( s_bruto < menor ||menor ==0){
               menor = s_bruto;
          }
           if(s_bruto > mayor )
               mayor = s_bruto;
     }
     cout<<"La diferencia entre el mayor y menor sueldo es:"<<mayor-menor;

     return 0;

}