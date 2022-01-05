//Tema1
#include <iostream>
#include <cstring>
using namespace std;
int main(){
  int l = 0;
  int q = 0;
  int n = 1;
  char str[100];
  cout<<"Ingrese la frase";
  cin.getline(str,100,'\n');
  l = strlen(str);

  while(q < l){
    if(str[q] - ' '  == 0){
      n++;
    }
    q++;
  }
  cout<<"La frase tiene "<<n<<" palabras";
  return 0;
}
