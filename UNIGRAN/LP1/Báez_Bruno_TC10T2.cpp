#include <iostream>
#include <cstdlib>
//Tema2
//@Bruno Baez
using namespace std;
int main(){
	int h = 0;
	int mul = 1;
	cout<<"Ingrese el tamanho del vector";
	cin>>h;
	int v[h];
	for(int q = 0 ;q<h ;q++){
		cout<<"Ingrese el elemento V["<<q+1<<"]"<<endl;
		cin>>v[q];
		mul = mul * v[q];
	}

	cout<<"La multiplicacion de sus elementos es "<<mul<<"\n";
	system("PAUSE");
	return 0;	
	
	
}
