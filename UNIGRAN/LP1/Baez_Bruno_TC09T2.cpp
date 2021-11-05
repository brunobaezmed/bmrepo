//Tema2
#include <iostream>
#include <cstdlib>
//@Bruno Báez
using namespace std;
int main(){
	int cant_horas = 0;
	int res = 0;
	cout<<"Ingrese la cantidad de horas trabajadas"<<"\n";
	cin>>cant_horas;
	
	if(cant_horas <= 40){
	
	res = cant_horas*16*24*7;
	cout<<"Su salario semanal es "<<res<<"$\t";
	
	}else{
		res = ((cant_horas - 40)*20*24*7)+(40*16*24*7);
		cout<<"Su salario semanal es "<<res<<"$\t";		
	}
	system("PAUSE");
	return 0;	
}
