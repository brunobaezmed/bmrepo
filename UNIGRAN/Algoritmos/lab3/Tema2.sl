//Tema2	

var categoria:numerico
var precio:numerico
inicio
	
	cls()
	imprimir("Coloque la categoria y el precio del producto\n")
	leer(categoria,precio)
	
	eval{
			
	caso(categoria==1)
		imprimir("El producto tiene un descuento de: ",precio*0.1," y el precio final es ",precio-precio*0.1)
			
	caso(categoria==2)
		 imprimir("El producto tiene un descuento de: ",precio*0.05," y el precio final es ",precio-precio*0.05)
			
	caso(categoria==3)
		 imprimir("El producto tiene un descuento de: ",precio*0.25," y el precio final es ",precio-precio*0.25)
			

		}



fin