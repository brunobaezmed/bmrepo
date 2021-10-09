//Tema4 
var vect:vector[*]numerico
var i=1
var n,c:numerico
var r1=0
inicio
	cls()	
	imprimir("Ingrese la cant de elementos del vector\n")
	leer(n)
	dim(vect,n)
	mientras(i<=n){
		imprimir("V[",i,"]= ")
		leer(vect[i])
		i=i+1
		}
	i=1
	imprimirVectorC(vect)
	mientras(i<=n){
		c=cantVeces(vect,vect[i])
		si(c>=2&&r1==0){
			r1=i
			
			}
		i=i+1
		}
	imprimir("\n Primer elemento repetido ",vect[r1])

fin

subrutina imprimirVectorC(vect:vector[*]numerico)
   var i=1
	inicio
		imprimir("\n V[]= ")
	mientras(i<=alen(vect)){
		imprimir(vect[i]," ")
		i=i+1
	}
	
	fin

subrutina cantVeces(vect:vector[*]numerico;el:numerico)retorna numerico
	var i=1
	var c=0
	inicio
		mientras(i<=alen(vect)){
			si(el==vect[i]){
				c=c+1
				}
		i=i+1
		}
	retorna c
	fin

	
