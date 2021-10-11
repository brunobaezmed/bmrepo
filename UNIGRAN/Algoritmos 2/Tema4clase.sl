//Tema1
var 
	vect:vector[*]numerico
var i,c,r:numerico
inicio	
	cls()
	i=1
	r=1
	leer(c)
	dim(vect,c)
	mientras(i<=c){
		vect[i]=random(1000)+1
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

	