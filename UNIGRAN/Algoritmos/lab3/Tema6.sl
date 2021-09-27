//Tema6
var n1,n2,n3:numerico

inicio	

	cls()

	imprimir("Ingrese los 3 numeros\n")
	leer(n1,n2,n3)

	eval{

	
	caso(n1>n2&&n1<n3)
		imprimir("El numero central es ",n1)

	caso(n2>n1&&n2<n3)
		imprimir("El numero central es ",n2)
	
   caso(n3>n2&&n3<n1)
		imprimir("El numero central es ",n3)


		
	caso(n1<n2&&n1>n3)
		imprimir("El numero central es ",n1)

	caso(n2<n1&&n2>n3)
		imprimir("El numero central es ",n2)
	
   caso(n3<n2&&n3>n1)
		imprimir("El numero central es ",n3)


		}




fin