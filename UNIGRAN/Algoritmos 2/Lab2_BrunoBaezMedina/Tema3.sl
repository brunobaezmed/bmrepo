//Tema3
var 
	mat:matriz[4,4]numerico
inicio
	cls()
	leerMat(mat)
	imprimir("Matriz inicial\n")
	imprimMatriz(mat)
	invertirF(mat)
	imprimir("Matriz final\n")
	imprimMatriz(mat)
fin
	subrutina invertirF(ref mat:matriz[*,*]numerico)
	 var mat2:matriz[*,*]numerico
		n=alen(mat)
		m=alen(mat[1])
		i,j:numerico
	inicio
		dim(mat2,n,m)

		desde i=1 hasta n{
			desde j=1 hasta m{
			mat2[i][j]=mat[n+1-i][j]			
			}
			
	}

		desde i=1 hasta n{
			desde j=1 hasta m{
			mat[i][j]=mat2[i][j]			
			}
			
	}

	
	fin



	subrutina leerMat(ref mat:matriz[*,*]numerico)
		var 
			n=alen(mat)
			m=alen(mat[1])
			i=1
			j=1
	inicio

		desde i=1 hasta n{
			desde j=1 hasta m{
			imprimir("Ingrese el valor de M[",i,"][",j,"]")	
		   leer(mat[i][j])
				}
			}
	fin
	
	subrutina imprimMatriz(mat:matriz[*,*]numerico)
		var 
			n=alen(mat)
			m=alen(mat[1])
			
			i=1
			j=1
	inicio
		desde i=1 hasta n{
			desde j=1 hasta m{
			imprimir(mat[i][j],"\t")			
			}
			imprimir("\n")
	}
	fin