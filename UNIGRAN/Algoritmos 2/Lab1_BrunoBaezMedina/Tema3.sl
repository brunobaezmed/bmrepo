//Tema3

inicio
  cls()
  cvect()
	
fin

subrutina cvect()
var vect1:vector[*]cadena
var vect2:vector[*]cadena
var n=0
var i=1
	inicio
		imprimir("Ingrese el numero de elementos del vector1 \n")
		leer(n)
		dim(vect1,n)
		dim(vect2,n-1)
		desde i=1 hasta n{
			imprimir("Ingrese V[",i,"]")
			leer(vect1[i])
			}
		i=1
		desde i=1 hasta n-1{
			si(ord(vect1[i])<=ord(vect1[i+1])){
				vect2[i]='1'	
			sino
				vect2[i]='0'
			
				}
			}
		imprimirVectorC(vect2)
		

	fin

subrutina imprimirVectorC(vect:vector[*]cadena)
   var i=1
	inicio
		imprimir("\n V[]= ")
	mientras(i<=alen(vect)){
		imprimir(vect[i]," ")
		i=i+1
	}

	fin