//Tema4

	var distancia:numerico
	var ndias:numerico

inicio

	cls()

	imprimir("Diga la distancia a recorrer y el numero de dias\n")
	leer(distancia,ndias)
	
	si(ndias>7&&distancia>800){
		imprimir("El precio de ida y vuelta es: ",800*250+(distancia-800)*0.7*250)
			
		
	sino
		imprimir("El precio de ida y vuelta es : ",distancia*250)
		}
fin