//Tema6
var cadena1,cadena2:cadena
var condicion=0
inicio
	cls()
	imprimir("Ingrese la cadena 1 y la cadena 2\n")
	leer(cadena1,cadena2)
	condicion=pos(cadena1,cadena2)
	si(condicion==0){


		imprimir("La cadena2 no se encuentra en la cadena1")
   sino
	imprimir("La cadena2 se encuentra en la cadena1 en la posicion ",condicion)
			}
	
//	imprimir(check(cadena1,cadena2))


fin
	subrutina check(ref cadena1:cadena;ref cadena2:cadena)retorna cadena
	
		

		inicio
		retorna cadena2
		fin