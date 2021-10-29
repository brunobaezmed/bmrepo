//Tema2
tipos Empresa:registro{
			 Persona:registro{
				
				Trabajador:registro{
						
					nombre:cadena
					ocupacion:cadena
					sueldo:numerico
				   carga_horaria:numerico
						}

					}
			

		}
var empresa1 :Empresa

inicio
	cls()
	imprimir("Ingrese el nombre del trabajador\n")
	leer(empresa1.Persona.Trabajador.nombre)
	
	imprimir("Ingrese su ocupacion\n")
	leer(empresa1.Persona.Trabajador.ocupacion)
	
	imprimir("Ingrese su sueldo \n")
	leer(empresa1.Persona.Trabajador.sueldo)
	
	imprimir("Ingrese su carga horaria \n")
	leer(empresa1.Persona.Trabajador.carga_horaria)
	
	imprimir("tipos: ",empresa1.Persona.Trabajador.nombre,"\n")
	imprimir(empresa1.Persona.Trabajador.ocupacion,"\n")
	imprimir(empresa1.Persona.Trabajador.sueldo,"\n")
	imprimir(empresa1.Persona.Trabajador.carga_horaria,"\n")
fin