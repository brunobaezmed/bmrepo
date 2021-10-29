//Tema1
tipos 
	libro:registro{
		Titulo:cadena
		autor:cadena
		ano_publicacion:cadena
		editorial:cadena
		cant_paginas:numerico
	}

 var libro1: libro
inicio
	
	cls()
	imprimir("Ingrese el Titulo del libro\n")
	leer(libro1.Titulo)
	
	imprimir("Ingrese el autor \n")
	leer(libro1.autor)
	
	imprimir("Ingrese anho de publicacion \n")
	leer(libro1.ano_publicacion)
	
	imprimir("Ingrese la Editorial \n")
	leer(libro1.editorial)
	
	imprimir("Ingrese la cantidad de paginas \n")
	leer(libro1.cant_paginas)
	
	imprimir(libro1.Titulo," ",libro1.autor," ",libro1.ano_publicacion,"\n")
	imprimir(libro1.editorial," ",libro1.cant_paginas)
	

fin
