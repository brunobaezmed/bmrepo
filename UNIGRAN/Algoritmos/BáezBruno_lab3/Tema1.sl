//Tema1

var numero:numerico
var bandera=0
inicio
	
	cls()

	imprimir("Ingrese el numero\n")
	leer(numero)
	
	eval{
	
		caso(numero==1)
		imprimir("Es Lunes\n")
			
		caso(numero==2)
		imprimir("Es Martes\n")
	
		caso(numero==3)
		imprimir("Es Miercoles\n")
		
		caso(numero==4)
		imprimir("Es Jueves\n")
		
		caso(numero==5)
		imprimir("Es Viernes\n")
	
		caso(numero==6)
		imprimir("Es Sabado\n")

		caso(numero==7)
		imprimir("Es Domingo\n")

		sino
		imprimir("Numero invalido")
	}
fin