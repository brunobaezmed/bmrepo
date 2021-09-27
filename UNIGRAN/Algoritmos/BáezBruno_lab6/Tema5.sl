//Tema5	
var fras=""
var letra=""
var cantl=0
var cantpal=1
inicio
	cls()
	imprimir("Ingrese la frase y la letra\n")
	leer(fras,letra)
	contl_pal(fras,letra,cantl,cantpal)
	imprimir("Letra= ",letra," contador_letra= ",cantl,"\n contador_palabras= ",cantpal) 
fin

subrutina contl_pal(ref frase:cadena;letra:cadena;ref cantl:numerico;ref cantpal:numerico)
	var b=1

	inicio
		frase=lower(frase)
		letra=lower(letra)

		mientras(b<=strlen(fras)){

				si(fras[b]==letra){
					cantl=cantl+1
					}	
				si(fras[b]==' '){
					cantpal=cantpal+1
					}


			b=b+1

				}

	fin




