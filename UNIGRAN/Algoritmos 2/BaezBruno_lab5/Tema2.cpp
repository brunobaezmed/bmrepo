//Tema2

#include <iostream>
using namespace std;
int main(){
	
	int h = 0;
	int m = 0;
	int c = 1;
	int v = 0;
	int u = 0;
	int q = 0;
	int b = 0;
	int f = 0;
	cout<<"Ingrese la cant de filas y columnas a generar\n";
	cin>>h>>m;
	int mat[h][m];

	q = h;
	f = m;
	while(c<=h*m){

		for( v = b;v < f;++v){
			mat[u][v] = c++; 
		}
		for(u = b +1;u < q;++u){
			mat[u][v-1] = c++;
		}
		for(v = f -1;v > b && u > b+1;--v){
			mat[u-1][v-1] = c++;
		}
		for(u = q-1 ;u > b+1;--u){
			mat[u-1][v] = c++;
		}

		b++;
		q--;
		f--;
	}

	

	for( u = 0 ; u < h ;++u){
		for(v = 0 ; v< m ;++v){
			cout<<mat[u][v]<< "\t";
			}
			cout<<"\n";
	}

	return 0;
}
