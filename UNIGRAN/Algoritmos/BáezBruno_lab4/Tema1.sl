//Tema 1
var n,sum,prom:numerico
var q=1
 inicio
	 cls()
	 imprimir("Ingrese un numero natural\n") 
	 leer(n)
	mientras(q<n){
	si(q%3==0){
		sum=sum+q
		prom=prom+1
		}
	q=q+1
	}

	imprimir("La suma total de los numeros multipos de 3 y menores a ",n," es ",sum," y el promedio es ",sum/prom)
 fin