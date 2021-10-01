//Ejercitario Tema7
var pal:cadena
inicio
	cls()
	imprimir("Ingrese una frase")
	leer(pal)
	ejerc7(pal)

fin

subrutina ejerc7(frase:cadena)
	var i=1
	inicio
		mientras(i<=strlen(frase)){
			imprimir(i,"\t",frase[i],"\t",ord(frase[i]),"\n")
			i=i+1
		 }


	fin

