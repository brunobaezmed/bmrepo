//Tema5
var pal:cadena
var n=1
inicio
	cls()
	imprimir("Ingrese la palabra a modificar\n")
	leer(pal)
	mientras(n<=strlen(pal)){
		
		si(pal[n]>='a'&&pal[n]<='z'){

			pal[n]=ascii(ord(pal[n])-32)
			sino
			pal[n]=ascii(ord(pal[n])+32)
			}

		n=n+1
		}


	imprimir(pal)
fin
