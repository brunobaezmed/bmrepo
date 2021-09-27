//Tema3  x^2+y^2=25   r=5  x-y+2=0	
var x,y:numerico
inicio
	cls()
	imprimir("Coloque las coordenadas X e Y \n")
	leer(x,y)
	si(x>5||y>5||x<-5||y<-5){

				imprimir("Esta afuera de la circunferencia, ")
					si(y>0){
							imprimir("por encima ")
					
					sino
						 imprimir("por debajo")
								}
				
		sino
		imprimir("Esta dentro de la circunferencia ")
					
		}

	eval{
			caso(x-y==-2)
			imprimir("y tambien es un punto de la recta x-y+2=0")
		}
	

fin