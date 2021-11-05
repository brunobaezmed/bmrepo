#include <iostream>
#include <cstdlib>
//Tema1
//@Bruno Baez
using namespace std;
int main(){
	int h = 0;
	int sum = 0;
	cout<<"Ingrese el tamanho del vector"<<"\n";
	cin>>h;
	int v[h];
	for(int q = 0 ;q<h ;++q){
		cout<<"Ingrese el elemento V["<<q+1<<"]\n";
		cin>>v[q];
		sum = sum + v[q];
	}
	cout<<"La suma de sus elementos es "<<sum<<"\t";
	system("PAUSE");
	return 0;
}
