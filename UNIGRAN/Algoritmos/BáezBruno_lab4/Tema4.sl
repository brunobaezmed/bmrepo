//Tema4
var n,q,f:numerico
var condicion=0
var producto=1

  inicio	
	cls()
	imprimir("Coloque n\t")
	leer(n)
	
	desde q=3 hasta n{
		
		f=2
		mientras(f<q){
			
			si (q%f==0){
				condicion=1
				f=q
          sino
			  f=f+1
				}
			}
		si(condicion==0){
			producto=producto*q
			}
		condicion=0

	}

	 imprimir("El producto de los numeros primos entre 2 hasta ",n," es ",producto)


  fin