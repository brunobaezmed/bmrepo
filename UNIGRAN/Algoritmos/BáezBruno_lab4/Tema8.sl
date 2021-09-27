//Tema8
var c,m,q,n:numerico
var r=2
	inicio
		cls()
		
		imprimir("Ingrese N\n")
		leer(n)
		imprimir("La serie de ",n," terminos es:\n")
		c=0
		m=1
		desde r=0 hasta n{
			imprimir(c,"\n")
			q=c+m
			c=m
			m=q
			}

	fin