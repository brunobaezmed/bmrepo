//Tema2
var palabra:cadena
inicio
	cls()
	imprimir("Ingrese la palabra ")
	leer(palabra)
	palabra=agrandar(palabra)
	imprimir(palabra)
		

fin

subrutina agrandar(palabra:cadena)retorna cadena
	var r=1
	var mayus=palabra
 	inicio
			mientras(r<=strlen(palabra)){

				 si(palabra[r]>='a'&&palabra[r]<='z'){
					
				
					mayus[r]=ascii(ord(palabra[r])-32)
				
					sino
					mayus[r]=palabra[r]
					}
				
			
				r=r+1
				}
	retorna mayus
	fin