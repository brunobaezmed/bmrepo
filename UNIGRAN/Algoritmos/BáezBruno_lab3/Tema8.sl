//Tema8	

var a,b,c:numerico
var x1,x2:numerico

inicio
	
	cls()
	imprimir("Ingrese el el coeficiente de x^2,de x y el termino independiente de la ecuacion \n")
	leer(a,b,c)
	
	si(b*b-4*a*c>=0){

		x1=(-b+sqrt(b*b-4*a*c))/(2*a)
		x2=(-b-sqrt(b*b-4*a*c))/(2*a)
		
		imprimir("Las raices son x1= ",x1," y x2= ",x2)

	sino
		x1=sqrt(-(b*b-4*a*c))/(2*a)
		x2=sqrt(-(b*b-4*a*c))/(2*a)
		imprimir("Las raices son imaginarias, x1= ",-b/(2*a),"+",x1,"i y x2= ",-b/(2*a), "-",x2,"i")


	}



fin