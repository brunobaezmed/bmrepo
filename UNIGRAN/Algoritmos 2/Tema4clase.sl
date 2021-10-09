//Tema4clase
var 
vect1,vect2:vector[*]numerico
n,i:numerico
inicio
	i=1
	cls()
	imprimir("Ingrese el tamanho del vector \n")
	leer(n)
	dim(vect1,n)
	dim(vect2,n-1)
	mientras(i<=n){
		imprimir("Vect1[",i,"]=")
		leer(vect1[i])
		i=i+1
	}
		i=1
	mientras(i<=n){
		si(i<n){
			vect2[i]=vect1[i]+vect1[i+1]
		}
		i=i+1
	}

		i=1
		mientras(i<=n-1){
		imprimir("Vect2[",i,"]=",vect2[i],"\n")
		i=i+1
	}
	


	
fin