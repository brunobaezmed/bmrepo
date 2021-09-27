//Tema3
var horas_trabajadas:numerico
var paga_por_hora:numerico

inicio

	cls()
	imprimir("Ingrese las horas trabajadas semanalmente y la paga por hora\n")
	leer(horas_trabajadas,paga_por_hora)

	si(horas_trabajadas<=40){
			
		imprimir("El empleado debe recibir: ",horas_trabajadas*paga_por_hora*4)
	
	sino
		imprimir("El empleado debe recibir: ",40*paga_por_hora*4+((horas_trabajadas-40)*paga_por_hora*2)*4)
	

		}

fin