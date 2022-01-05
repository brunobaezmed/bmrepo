#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;
int main(){

     char frase[100];
     char pal[100];
     int a,e,i,o,u = 0;
     int q,r,q1 = 0; 
     int c1 = 0;
     bool condicion = false;
     cout<<"Ingrese la frase a procesar ";
     cin.getline(frase,100,'\n');

     cout<<"Ingrese la palabra a buscar ";
     cin.getline(pal,100,'\n');
     
     
     for(q = 0; frase[q] != '\0' ; q++){
          if(frase[q] == pal[0]){
               q1 = q;
               while(pal[r] != '\0'){
                    if(frase[q1] != pal[r])c1++;
                    q1++;
                    r++;
               }
               if(c1 == 0){ condicion = true; break;}
               q1 = 0;
               r = 0;
     
               c1 = 0;
          }
     }     
     if(condicion){
          cout<<"La palabra "<<pal<<" se encuentra en la frase\n";

     }else{
          cout<<"La palabra "<<pal<<" NO se encuentra en la frase\n";
          
     }




     for(q = 0; frase[q] != '\0' ; q++){
          if(frase[q] >= 'a' && frase[q] <= 'z')
          frase[q] = frase[q] - 32;
     }
     for(q = 0;frase[q] != '\0'; q++ ){
          if(frase[q] == 'A')a++;
          if(frase[q] == 'E')e++;
          if(frase[q] == 'I')i++;
          if(frase[q] == 'O')o++;
          if(frase[q] == 'U')u++;
               
     }     
     cout<<"Cantidad de a="<<a;
     cout<<"\nCantidad de e="<<e;
     cout<<"\nCantidad de i="<<i;
     cout<<"\nCantidad de o="<<o;
     cout<<"\nCantidad de u="<<u;

     system("PAUSE");
     return 0;
}
