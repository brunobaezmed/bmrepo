//Tema2
var anho:numerico

inicio
	cls()
	
	imprimir("Ingrese un año\n")
	leer(anho)

	eval{

	caso(anho%4==0&&!(anho%100==0))
		imprimir("El anho es bisiesto")
	
		
	caso(anho%100==0&&anho%400==0)
		imprimir("El anho es bisiesto")
	
	sino
		imprimir("El anho no es bisiesto")
		}

fin