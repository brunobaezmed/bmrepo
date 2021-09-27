//Trabaja de Lunes a Viernes

var Tarifa_Horaria,Cantidad_HorasDiarias: numerico

inicio
	
	imprimir("Inserte la tarifa horaria\n y la cantidad de horas diarias\n")
	leer(Tarifa_Horaria,Cantidad_HorasDiarias)
	
	imprimir("Su salario semanal es ",Tarifa_Horaria*Cantidad_HorasDiarias*5)

fin