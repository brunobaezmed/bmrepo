//Tema1
var palabra:cadena
inicio
	cls()
	imprimir("Ingrese la palabra ")
	leer(palabra)
	palabra=achicar(palabra)
	imprimir(palabra)
		

fin

subrutina achicar(palabra:cadena)retorna cadena
	var r=1
	var minus=palabra
 	inicio
			mientras(r<=strlen(palabra)){

				 si(palabra[r]>='A'&&palabra[r]<='Z'){
					minus[r]=ascii(ord(palabra[r])+32)
				
					sino
					minus[r]=palabra[r]
					}
				
				r=r+1
				}
	retorna minus
	fin