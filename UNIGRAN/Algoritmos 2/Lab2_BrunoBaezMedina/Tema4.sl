//Tema4
	var n:numerico
		mat:matriz[*,*]numerico
inicio
	cls()
	imprimir("Ingrese el tamaño de la matriz NxN\n")
	leer(n)
	dim(mat,n,n)
	leerMat(mat)
	imprimMatriz(mat)
	imprimir("\n")
	imprimBordes(mat)

fin
subrutina imprimBordes(mat:matriz[*,*]numerico)
		var 
			n=alen(mat)
			mat2:matriz[*,*]numerico
			i=1
			j=1
	inicio
		si(n==3){
			desde i=1 hasta n{
				desde j=1 hasta n{
				si(mat[i][j]<>mat[n-i+1][n-j+1]){
					imprimir(mat[i][j],"    ")		
				sino
					imprimir("\t    ")
					}
	
				}
				imprimir("\n")
			}

	  sino
		n=n-2
		dim(mat2,n,n)
		desde i=1 hasta n{
				desde j=1 hasta n{
				mat2[i][j]=mat[i+1][j+1]
				}
			}
		n=n+2
		
		
		desde i=1 hasta n{
				desde j=1 hasta n{
				si(i<n&&j<n&&i>1&&j>1&&mat[i][j]==mat2[i-1][j-1]){
					imprimir("\t")
				sino
					imprimir(mat[i][j],"\t")
					}
				}
			 imprimir("\n")
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