//Tema2	
var cad1,cad2:cadena
var n:numerico
var i:numerico
inicio
	cls()
	i=1
	imprimir("Ingrese la cadena1\n")
	leer(cad1)
	imprimir("Ingrese la cadena2\n")
	leer(cad2)
	n=cantV(cad1,cad2)
	imprimir("Se repitio ",n," veces")
fin
subrutina cantV(cad1:cadena;cad2:cadena)retorna numerico
var n=0
var i=1
inicio
		mientras(i<strlen(cad2)){
		
			i=pos(cad2,cad1,i)
			si(i<>0){
				n=n+1
				i=i+strlen(cad1)	
				sino
					i=strlen(cad2)
				}
		}
		retorna n
fin