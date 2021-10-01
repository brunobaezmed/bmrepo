//Tema2
var npiezas,p_aptas,long:numerico
var n=1
inicio
	cls()
	imprimir("Ingrese la cantidad de piezas a procesar\n")
	leer(npiezas)
	mientras(n<=npiezas){
			imprimir("Inserte la longitud de la pieza n",n,"\n")
			leer(long)
		si(long>=1.2&&long<=1.3){
				p_aptas=p_aptas+1
			}
		n=n+1;
		}
	imprimir("Hay ",p_aptas," piezas de hierro aptas")
fin