//Tema2
var in:numerico
  inicio
	cls()
	imprimir("Ingrese el numero entero\n")
	leer(in)
	in=CantidadDeDivisores(in)
	imprimir("La cantidad de divisores es ",in)
  fin

subrutina CantidadDeDivisores(ref in:numerico)retorna numerico
   var m=1
	var cant=0
	inicio
	
		mientras(m<=in){
			si(in%m==0){
				cant=cant+1
          
				}
	
			m=m+1
			}
		retorna cant
	fin
