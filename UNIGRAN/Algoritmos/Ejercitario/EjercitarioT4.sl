//Tema4
inicio
	cls()
	imprimir(cantParIm());



fin
subrutina cantParIm()retorna cadena
var N,i,npar,nimpar,nentero:numerico
var r:cadena
	inicio
		i=1
		imprimir("Inserte la cantidad de numeros enteros \n")
		leer(N)
		
		mientras(i<=N){
			
			imprimir("Ingrese el numero entero\n")
			leer(nentero)
			si(nentero%2==0){
					npar=npar+1
				sino
					nimpar=nimpar+1

				}
			i=i+1
			}
		  npar=(npar*100)/N
		  nimpar=(nimpar*100)/N
		  r="Hay "+str(npar)+"%pares y "+str(nimpar)+"%impares"
		
		 retorna r


	fin