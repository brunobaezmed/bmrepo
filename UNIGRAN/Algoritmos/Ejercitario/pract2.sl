/*
23

2^5 2^4  2^3 2^2 2^1 2^0
	  1    0   0   0   0
	  
	  0	 0   1	0   0

							
	  0	 0		0	1   0

	  0	 0		0	0	 1 

		1   0   1   1   1

	convertir un numero de decimal a binario 

*/
var h2,s,exp:numerico
	
	inicio
		
		cls()
		h2=1
		exp=1
		imprimir("Ingrese el numero a convertir en binario\n")
		leer(s)
		
		mientras(h2<=s){
			h2=2^exp
			exp=exp+1
			}
			exp=exp-2
			h2=2^exp
		mientras(s<>0){
			si(s-h2>=0){	
					
				imprimir("1")
				s=s-h2
				exp=exp-1
				h2=2^exp
		si(exp>=0&&s==0){
					exp=exp+1
							mientras(exp>0){
									imprimir("0")
									exp=exp-1

									}
					}
		

			sino
				imprimir("0")
				exp=exp-1
				h2=2^exp
					
			si(exp>=0&&s==0){

							mientras(exp>0){
									imprimir("0")
									exp=exp-1

									}
					}
				

						 }
			}
		
		

	fin