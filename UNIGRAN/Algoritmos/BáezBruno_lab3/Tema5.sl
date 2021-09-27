//Tema 5

var a,b,c:numerico
var bandera=0//usamos para verificar la condicion

inicio
	
	cls()
	imprimir("Ingrese el lado a\n")
	leer(a)
	
	imprimir("Ingrese el lado b\n")
	leer(b)

	imprimir("Ingrese el lado c\n")
	leer(c)
	


	si(b+a>c){
		bandera=bandera+1
		}
	si(b+c>a){
		bandera=bandera+1
		}
	si(a+c>b){
		bandera=bandera+1
		}
	

	si(bandera==3){
		imprimir("Son lados de un triangulo\n")
	sino
		imprimir(" No son lados de un triangulo")
		}

					
fin