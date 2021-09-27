var n=0
var m=1
var q=1
	inicio

		cls()
		imprimir("Inserte el numero\n")
		leer(n)
	
		imprimir("*\t")
		mientras(m<=n){

			imprimir(m,"\t")
			m=m+1
				}
			imprimir("\n")
		
		m=1
		q=1
	
		mientras(q<=n){

			imprimir(q,"\t")

			mientras(m<=n){

				imprimir(m*q,"\t")
				m=m+1
					}
				imprimir("\n")
		   m=1
			q=q+1
				
			}

	fin


	