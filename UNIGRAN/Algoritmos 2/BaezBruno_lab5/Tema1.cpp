//Tema1
#include <iostream>
using namespace std;

int main(){

	int r = 0;
	int rep =0 ;
	int c = 0;
	int t2 = 0;
	int min = 0;
	int v = 0;
	int u = 0;

	cout<<"Ingrese el tamanho del vector";
	cin>>r;

	int array[r];

	for(c = 0 ;c < r;++c){
		cout<<"v["<<c<<"]";
		cin>>array[c];
	}

	for(c = 0 ;c < r;++c){

		 v = c;
		for( u = c ; u <r-1 ; ++u){
			if( array[v] > array[u+1])
				v = u+1;

		}
		 min = array[v];
		 array[v] = array[c];
		 array[c] = min;
	}
	for( c =0 ;c < r;++c)cout<< array[c]<<" ";
	cout<<"\n";

	for(c = 0 ;c < r;++c){

		if(c+1<r &&array[c] ==array[c+1]  ){

			rep++;
		}


	}

	t2 = (r-rep)*2;
	int array2[t2];

	rep = 1;
	v = 0;

	for( c = 0 ;c < r ;++c){

		if(c+1 <r && array[c] == array[c+1]){
			rep ++;
		}else{
			if(v < t2){
				array2[v] = array[c];
				array2[v+1] = rep;
				rep = 1;
				v= v+2;
			}
		}


	}
	for( c =0 ;c < t2;++c)cout<< array2[c]<<" ";

	cout<<"\n";

	return 0;
}
