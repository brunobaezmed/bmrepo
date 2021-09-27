
var s1=0
var s2=1
var r1,r2,n,m:numerico

	inicio
		m=0
		r1=4
		r2=6
      cls()

		imprimir("Ingrese un numero\n")
		leer(n)
		
		mientras(m<n){
			
			s1=s1+r1
			r1=r1+3
	
			s2=s2*r2
			r2=r2+3
			m=m+1
					}
			imprimir("La division de ",n," terminos es ",s1/s2)
		
		




	fin