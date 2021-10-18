var 
	mat:matriz[*,*]numerico
	tr:matriz[*,*]numerico
	n,m,i,j:numerico
	band=TRUE
inicio
	cls()
	imprimir("Ingrese el numero de filas y columnas\n")
	leer(n,m)
	si(n<>m){
		imprimir("La matriz no es simetrica\n")
	sino
		dim(mat,n,m)
		leerMat(mat)
		tr=trans(mat)
		imprimMatriz(mat)
		imprimir("transpuesta=\n")
		imprimMatriz(tr)
		
		desde i=1 hasta n{
			desde j=1 hasta m{
				si(tr[i][j]<>mat[i][j]){
					band=FALSE
					j=n+1
					i=m+1
						}
					}
				}
		
		
	si(band == TRUE){
		imprimir("La matriz es simetrica")
		sino
		imprimir("La matriz  no es simetrica")
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

	subrutina trans( mat:matriz[*,*]numerico) retorna matriz[*,*]numerico
	var	n=alen(mat)
			m=alen(mat[1])
			tr:matriz[*,*]numerico
			i,j:numerico
	inicio
			dim(tr,n,m)
			desde i=1 hasta n{
				desde j=1 hasta m{
					tr[j][i]=mat[i][j]
				}

		}
		
		retorna tr
	fin
