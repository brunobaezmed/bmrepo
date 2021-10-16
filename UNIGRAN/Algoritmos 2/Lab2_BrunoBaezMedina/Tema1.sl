var
	mat:matriz[4,4]numerico
	sd,sf1,sfu,sc1,scu,i,j:numerico	
inicio
	cls()
	leerMat(mat)
	imprimMatriz(mat)
	sd=mat[1][1]+mat[2][2]+mat[3][3]+mat[4][4]
	sf1=mat[1][1]+mat[1][2]+mat[1][3]+mat[1][4]
	sfu=mat[4][1]+mat[4][2]+mat[4][3]+mat[4][4]
	sc1=mat[1][1]+mat[2][1]+mat[3][1]+mat[4][1]
	scu=mat[1][4]+mat[2][4]+mat[3][4]+mat[4][4]
	imprimir("suma diagonal principal=",sd,"\n")
	imprimir("suma primera fila=",sf1,"\n")
	imprimir("suma ultima fila=",sfu,"\n")
	imprimir("suma primera columna=",sc1,"\n")
	imprimir("suma ultima columna=",scu,"\n")
	

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
	