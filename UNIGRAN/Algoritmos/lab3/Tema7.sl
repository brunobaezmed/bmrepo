//Tema7

	var angulo:numerico

inicio
	
		cls()
		
		imprimir("Coloque el angulo entre 0� y 360�\n")
		leer(angulo)

		eval{

			caso(angulo<90)
				imprimir("Es un angulo agudo")
		
			caso(angulo==90)
				imprimir("Es un angulo recto")
			
			caso(angulo>90)
				imprimir("Es un angulo obtuso")
			
			
			
			
			}
		
	
fin