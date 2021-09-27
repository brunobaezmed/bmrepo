//Tema5
var num:numerico
var in:numerico
var t:numerico
var n:numerico
var v1,v2:numerico
	inicio
		cls()
		imprimir("Ingrese el numero con par de digitos\n")// n=654321 se debe mostrar 563412
		leer(num)
		in=num
		mientras(in>1){
			in=in/10
			t=t+1
			}
		in=num

		
		
		mientras(t>0){

			v1=int(in/10^(t-1))
			in=in-v1*10^(t-1)
			v2=int(in/10^(t-2))
			in=in-v2*10^(t-2)
			t=t-2
			imprimir(v2,v1)

			}
	fin