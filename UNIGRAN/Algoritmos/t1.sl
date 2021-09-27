
var r="Hello"
var n,m:numerico
inicio

 cls()
 leer(n)
 leer(m)
 imprimir(n," ",m ) 
 n=subfunctionMCDE(n,m)
 imprimir(" ",n," ",m)


fin

subrutina subfunctionMCDE(n: numerico;ref m:numerico) retorna numerico//function
	var c:numerico
	inicio
		
		c=1
		mientras(c<>0){
				c=m%n
				m=n 
            n=c 
				}


		retorna (m)
	fin
