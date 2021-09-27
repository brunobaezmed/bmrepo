//Tema2
var n:numerico
var e:numerico
var res=1

  inicio
	
	 cls()
	 imprimir("Coloque un numero natural\n")
	 leer(n)
	mientras(n<>int(n)){

	 imprimir("No es correcto,coloque un numero natural\n")
	 leer(n)

		}
	 desde e=1 hasta n{
		
		res=res*e;
		}
	 imprimir("El factorial de ",n," es ",res)

  fin