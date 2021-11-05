#include<iostream>
#include<stdlib.h>
using namespace std;
 /* Copyright @Báez Medina Bruno 27/10/2021 */ 
int main(){
	char nombre[20]="";
	int num =0;
	int n =0;
	int r =0;
	cout<<"Escriba su nombre ";
	cin>>nombre;
	cout<<"Hola "<<nombre<<" ingresa el numero de la tabla a aprender: ";
	cin>>num;
	cout<<"=============="<<endl;
	cout<<" Tabla del "<<num<<endl;
	cout<<"=============="<<endl;
    while(n < 10){
    	
    	r = (n+1)*num;
    	cout<<num<<" * "<<n+1<<" = "<<r<<endl;
    	n++;
    }
    cout<<"////////////////////////////////////////////"<<endl;
    cout<<"Gracias por utilizar el programa "<<nombre<<",podes seguir practicando "<<endl;
    cout<<"////////////////////////////////////////////"<<endl;
    cout<<"Programador: Bruno Baez Medina-Todos los derechos reservados-27/10/2021"<<endl;


    system("PAUSE");
	return 0;
}
