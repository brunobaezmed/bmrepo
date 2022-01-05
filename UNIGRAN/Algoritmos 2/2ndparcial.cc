#include <iostream>
using namespace std;
int main(){
	int n1,n2,j,i;
	int b = 0;
	int q = 0;
	int t1,t2= 0;
	bool c = false;
	int c2 = 0;

	cout<<" Ingrese el tamanho de la matriz 1 y 2";
	cin >>n1>>n2;
	int m1[n1][n1],m2[n2][n2];
	for(i = 0;i < n1; ++i){
		for(j = 0; j < n1; ++j){
			cout<< "Ingrese M1["<<i<<"]"<<"["<<j<<"]";
			cin>>m1[i][j];
		}
	}

	for(i = 0;i < n2; ++i){
		for(j = 0; j < n2; ++j){
			cout<< "Ingrese M2["<<i<<"]"<<"["<<j<<"]";
			cin>>m2[i][j];
		}
	}
	cout<<"\n";


	for(i = 0 ;i < n1 ; ++i ){
		for(j = 0;j < n1 ; ++j){
			cout<<m1[i][j]<<"\t";
		}
			cout<<"\n";
	}
	cout<<"\n";

	for(i = 0 ;i < n2 ; ++i ){
		for(j = 0;j < n2 ; ++j){
			cout<<m2[i][j]<<"\t";
		}
			cout<<"\n";
	}

	for(i = 0 ;i < n1 ; ++i ){
		for(j = 0;j < n1 ; ++j){

			if(m1[i][j] == m2[0][0] ){
				t1 = i;
				t2 = j;
				for(b = 0 ;b < n2;++b){
					for(q = 0 ;q< n2;++q){
						if( m1[t1][t2] ==m2[b][q]){
							c2++;
							}else{c2 =0;}
						
						t2++;
					}
					t1++;
					t2 = j;
				}
				if(c2 >= n2)c=true;
			}
			else{
				c2 = 0; 
			}
	
		

		}
	}

	if(c){
		cout<<"\n LA MATRIZ A CONTIENE A LA MATRIZ B";

	}
	else{
		cout<<"\n LA MATRIZ A NO CONTIENE A LA MATRIZ B";

	}




	cout<<"\n";

	return 0;
}
