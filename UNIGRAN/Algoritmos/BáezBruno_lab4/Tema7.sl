//Tema6
var n:numerico
var v=2
var exp=0
	inicio
		cls()
		imprimir("Coloque el numero\n")
		leer(n)

		si(n==1||n==0){
			imprimir(n)	
		sino	
		mientras(n<>1){
			
			mientras(n%v==0){

				exp=exp+1
				n=n/v
				}
			si(exp<>0){
			imprimir("factor= ",v," exponente= ",exp,"\n")
				}
			exp=0
			v=v+1

				}
		}
	fin	