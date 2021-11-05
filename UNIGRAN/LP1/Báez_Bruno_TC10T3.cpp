#include <iostream>
#include <cstdlib>
//Tema3
//@Bruno Baez
using namespace std;
int main(){
	int h = 0;
	cout<<"Ingrese el tamanho del vector";
	cin>>h;
	int v[h];
	for(int q = 0 ;q<h ;q++){
		cout<<"Ingrese el elemento V["<<q<<"]"<<endl;
		cin>>v[q];
	}
	for(int q = 0 ;q<h ;q++)
	cout<<"V["<<q<<"]="<<v[q]<<"\t";
	system("PAUSE");
	return 0;
}
