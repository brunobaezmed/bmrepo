//Tema1
var 
	vect:vector[15]numerico
var i,r:numerico
inicio	
	cls()
	i=1
	r=1
	mientras(i<=15){
		imprimir("Ingrese el valor de V[",i,"] de 1 a 50 ")
		leer(vect[i])
		i=i+1
	}		// 7 4 1 9
	
	imprimirVector(vect)
	ordenarAsc(vect)	
	imprimirVector(vect)
	
	
fin
subrutina imprimirVector(vect:vector[*]numerico)
   var i=1
	inicio
		imprimir("\n V[]= ")
	mientras(i<=alen(vect)){
		imprimir(vect[i]," ")
		i=i+1
	}

	fin


subrutina ordenarAsc(ref vect:vector[*]numerico) 
	var i=1
	var r=1
	var c=0
	inicio
			mientras(i<alen(vect)){
				mientras(r<alen(vect)){
					
					si(vect[r]>vect[r+1]){
							c=vect[r+1]
							vect[r+1]=vect[r]
							vect[r]=c
						}
					r=r+1
				}
					i=i+1
					r=1
		}


	fin

	